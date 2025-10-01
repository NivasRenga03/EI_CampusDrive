package src.commands;

import src.models.OfficeConfiguration;
import src.models.UserSession;

public class UserAuthenticationCommand {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public UserAuthenticationCommand(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    // Handle login
    public String login(String role) {
        if (!userSession.setRole(role)) {
            return "Please enter the correct role. Only admin or employee authentication is allowed.";
        }
        officeConfig.updateStatistics("User " + userSession.getRole() + " logged in successfully.");
        return "User authenticated successfully as " + userSession.getRole() + ".";
    }

    // Check current session
    public String me() {
        if (userSession.getRole().isEmpty()) {
            return "You are not logged in.";
        }
        return "You are logged in as " + userSession.getRole();
    }

    // Handle logout
    public String execute() {
        String currentRole = userSession.getRole();
        if (currentRole.isEmpty()) {
            return "No active session found.";
        }
        userSession.clearRole(); 
        officeConfig.updateStatistics("User " + currentRole + " logged out successfully.");
        return "You're logged out successfully.";
    }
}
