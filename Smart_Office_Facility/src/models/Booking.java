package src.models;

import src.utils.Logger;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Booking {
    private String id;
    private Date start;
    private Date end;
    private String user;

    public Booking(String user, Date start, Date end) {
        this.id = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getUser() {
        return user;
    }

    // Notify user about cancellation
    public void notifyUser() {
        // Assuming Email.send is a static method to send emails
        Email.send(user, "Booking Cancellation",
                "Booking cancellation for booking ID " + id +
                        " scheduled from " + start.toString() + " to " + end.toString() +
                        " due to inactivity for 5 minutes. Thank you.");
    }

    // Check room occupancy and remove booking if inactive
    public void statusCheck(Room room) {
        OfficeConfiguration officeConfig = OfficeConfiguration.getInstance();
        Booking booking = room.getBookingById(this.id);

        if (booking == null) {
            return;
        }

        Logger.log("Checking status of room " + room.getId());

        if (!room.isOccupied()) {
            officeConfig.updateStatistics(
                    "Room " + room.getId() + " is unoccupied due to inactivity for configured delay with booking ID " + booking.id
            );
            room.removeBooking(this.id);
            this.notifyUser();
            officeConfig.notifyObservers(room);
            Logger.log("Room " + room.getId() + " booking removed due to inactivity.");
        }
    }

    // Proper JSON-like output for printing bookings
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return String.format(
                "{\"id\":\"%s\",\"start\":\"%s\",\"end\":\"%s\",\"user\":\"%s\"}",
                id, sdf.format(start), sdf.format(end), user
        );
    }
}
