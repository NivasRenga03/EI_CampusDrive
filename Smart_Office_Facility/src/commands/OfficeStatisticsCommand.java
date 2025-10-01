package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;

public class OfficeStatisticsCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public OfficeStatisticsCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute() {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }
        return officeConfig.getStatistics();
    }
}