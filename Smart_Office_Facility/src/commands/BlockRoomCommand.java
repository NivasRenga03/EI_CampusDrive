package src.commands;
import src.models.Booking;
import src.models.OfficeConfiguration;
import src.models.Room;
import src.models.UserSession;
import src.utils.Logger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class BlockRoomCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public BlockRoomCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    private boolean checkBooking(Room room, LocalDateTime start, LocalDateTime end) {
        for (Booking booking : room.getBookings()) {
            LocalDateTime bStart = booking.getStart().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            LocalDateTime bEnd = booking.getEnd().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            if (start.isBefore(bEnd) && end.isAfter(bStart)) {
                return true; // overlapping
            }
        }
        return false;
    }

    public String execute(int roomId, String time, int duration) {
        Room room = officeConfig.getRoom(roomId);
        if (room == null) {
            return "Room " + roomId + " does not exist.";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime;
        try {
            localTime = LocalTime.parse(time, formatter);
        } catch (Exception e) {
            return "Invalid time format. Please use HH:mm:ss.";
        }
        LocalDateTime startTime = LocalDateTime.now()
                .withHour(localTime.getHour())
                .withMinute(localTime.getMinute())
                .withSecond(localTime.getSecond())
                .withNano(0);

        // Calculate end time
        LocalDateTime endTime = startTime.plusMinutes(duration);

        // Check if in the past
        if (startTime.isBefore(LocalDateTime.now())) {
            return "Cannot book a room in the past. Please choose a future time.";
        }

        // Check if booking crosses midnight
        if (!startTime.toLocalDate().equals(endTime.toLocalDate())) {
            return "Bookings must be completed within today. You cannot book beyond midnight.";
        }

        // Check overlapping
        if (checkBooking(room, startTime, endTime)) {
            return "Room " + roomId + " is already booked during this time. Cannot book.";
        }

        // Create booking
        Date startDate = Date.from(startTime.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endTime.atZone(ZoneId.systemDefault()).toInstant());
        Booking booking = new Booking(userSession.getRole(), startDate, endDate);
        room.getBookings().add(booking);

        // Schedule status check after booking start + configured release delay
        long delay = Duration.between(LocalDateTime.now(), startTime).toMillis();
        long releaseDelay = officeConfig.getReleaseDelayMillis();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                booking.statusCheck(room);
            }
        }, delay + releaseDelay);
        officeConfig.updateStatistics(
                "Room " + roomId + " booked from " + startTime.toLocalTime() + " for " + duration + " minutes. Booking ID: " + booking.getId()
        );
        Logger.log(
                "Booking ID: " + booking.getId() + " Room " + roomId + " booked from " + startTime.toLocalTime() + " - " + endTime.toLocalTime()
        );

        return "Room " + roomId + " booked from " + startTime.toLocalTime() + " for " + duration + " minutes.";
    }
}
