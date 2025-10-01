package src.models;

import java.util.Arrays;
import java.util.List;

public class UserSession {
    private static UserSession instance;

    // Allowed roles
    private final List<String> roles = Arrays.asList("admin", "employee");
    private String role;

    private UserSession() {
        this.role = ""; // no role assigned initially
    }

    // Singleton instance
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Strict role validation (NO exceptions)
    public boolean setRole(String role) {
        if (role == null || !roles.contains(role.toLowerCase())) {
            return false;  // invalid role
        }
        this.role = role.toLowerCase();
        return true; // valid role
    }

    public String getRole() {
        return role;
    }

    public void clearRole() {
        this.role = "";
    }

    // Utility methods
    public boolean isAdmin() {
        return "admin".equals(role);
    }

    public boolean isEmployee() {
        return "employee".equals(role);
    }
}
