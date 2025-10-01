package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;
import src.models.Room;

public class RemoveOccupantCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public RemoveOccupantCommand(OfficeConfiguration officeConfig, UserSession userSession) {
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

        String message = room.removeOccupants(count);
        officeConfig.notifyObservers(room);
        return message;
    }
}
