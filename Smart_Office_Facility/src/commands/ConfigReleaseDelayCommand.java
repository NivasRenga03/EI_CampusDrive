package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;

public class ConfigReleaseDelayCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public ConfigReleaseDelayCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    public String execute(long millis) {
        if (!userSession.getRole().equals("admin")) {
            return "You are not authorized to perform this action.";
        }
        if (millis < 0) {
            return "Invalid delay. Please enter a non-negative number of milliseconds.";
        }
        officeConfig.setReleaseDelayMillis(millis);
        return "Auto-release delay set to " + millis + " ms.";
    }
}
