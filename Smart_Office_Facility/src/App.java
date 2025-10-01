package src;

import src.utils.CommandParser;
import src.models.OfficeConfiguration;
import src.observers.ACController;
import src.observers.LightController;
import src.models.UserSession;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        OfficeConfiguration officeConfig = OfficeConfiguration.getInstance();
        UserSession userSession = UserSession.getInstance();
        CommandParser parser = new CommandParser(officeConfig, userSession);

        officeConfig.addObserver(new ACController());
        officeConfig.addObserver(new LightController());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Office Meeting Room Management System");

        // Display available commands
        System.out.println("Available Commands:");
        System.out.println("1. Config room count <number>");
        System.out.println("2. Config room max capacity <roomId> <capacity>");
        System.out.println("3. Block room <roomId> <time> <duration>");
        System.out.println("4. Add occupant <roomId> <count>");
        System.out.println("5. Remove occupant <roomId> <count>");
        System.out.println("6. Config release delay <millis>");
        System.out.println("7. Cancel room <roomId> [bookingId]");
        System.out.println("8. Status room <roomId>");
        System.out.println("9. Statistics");
        System.out.println("10. Logout");
        System.out.println("11. Me");
       
        

        while (true) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String action = parts[0];
            String login = parts.length > 1 ? parts[1] : "";

           if (action.equals("Login")) {
    if (!userSession.getRole().isEmpty()) {
        System.out.println("You are already logged in as " + userSession.getRole() + ".");
        continue;
    }

    // Validate role
    if (!login.equalsIgnoreCase("admin") && !login.equalsIgnoreCase("employee")) {
        System.out.println("Invalid role. Only 'admin' or 'employee' are allowed.");
        continue;
    }

    userSession.setRole(login.toLowerCase());
    officeConfig.updateStatistics("User " + userSession.getRole() + " has logged in successfully.");
    System.out.println("User authenticated successfully.");
    continue;
}

            String output = parser.parse(input);
            System.out.println(output);
        }
    }
}