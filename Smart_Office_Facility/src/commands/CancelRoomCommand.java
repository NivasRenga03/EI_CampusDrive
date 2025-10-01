package src.commands;

import src.models.Booking;
import src.models.OfficeConfiguration;
import src.models.UserSession;
import src.models.Room;
import src.utils.Logger;

public class CancelRoomCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public CancelRoomCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(int roomId, String bookingId) {
        Room room = officeConfig.getRoom(roomId);
        if (room == null) {
            return "Room " + roomId + " does not exist.";
        }

        if (room.getBookings().isEmpty()) {
            return "Room " + roomId + " is not booked. Cannot cancel booking.";
        }

        if (bookingId == null || bookingId.isEmpty()) {
            if (!userSession.getRole().equals("admin")) {
                return "You are not authorized to cancel all bookings. Please cancel only your bookings.";
            }
            room.clearBookings();
            return "All bookings for Room " + roomId + " cancelled successfully.";
        }

        Booking booking = room.getBookingById(bookingId);
        if (booking == null) {
            return "Booking " + bookingId + " does not exist. Cannot cancel.";
        }

        if (!userSession.getRole().equals("admin") && !booking.getUser().equals(userSession.getRole())) {
            return "You are not authorized to cancel booking with id " + bookingId + ". Please cancel only your bookings.";
        }

        room.removeBooking(bookingId);
        officeConfig.updateStatistics("Booking with booking id " + bookingId + " for Room " + roomId + " cancelled successfully.");
        officeConfig.notifyObservers(room);
        return "Booking with booking id " + bookingId + " for Room " + roomId + " cancelled successfully.";
    }
}