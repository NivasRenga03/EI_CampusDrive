package src.commands;

import src.models.Booking;
import src.models.OfficeConfiguration;
import src.models.UserSession;
import src.models.Room;

public class RoomStatusCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public RoomStatusCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(int roomId) {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }

        Room room = officeConfig.getRoom(roomId);
        if (room == null) {
            return "Room " + roomId + " does not exist.";
        }

        return "Room " + roomId + " is currently " + (room.isOccupied() ? "occupied" : "unoccupied") +
               " and " + room.getBookings().toString() + ".";
    }
}