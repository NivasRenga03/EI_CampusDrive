package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;
import src.models.Room;

public class AddOccupantCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public AddOccupantCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(int roomId, int count) {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }

        Room room = officeConfig.getRoom(roomId);
        if (room == null) {
            return "Room " + roomId + " does not exist.";
        }

        if (room.getBookings().isEmpty()) {
            return "Room " + roomId + " is not booked. Cannot add occupants.";
        }

        String message = room.addOccupants(count);
        officeConfig.notifyObservers(room);
        return message;
    }
}