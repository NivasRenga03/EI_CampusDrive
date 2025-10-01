package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;

public class ConfigRoomMaxCapacityCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public ConfigRoomMaxCapacityCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(int roomId, int capacity) {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }
        return officeConfig.setRoomMaxCapacity(roomId, capacity);
    }
}