package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;

public class ConfigRoomCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public ConfigRoomCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(int count) {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }
        return officeConfig.configureRooms(count);
    }
}