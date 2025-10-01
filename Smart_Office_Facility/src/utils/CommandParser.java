package src.utils;

import src.models.OfficeConfiguration;
import src.models.UserSession;
import src.commands.*;

public class CommandParser {
    private OfficeConfiguration officeConfig;
    private UserSession userSession;

    public CommandParser(OfficeConfiguration officeConfig, UserSession userSession) {
        this.officeConfig = officeConfig;
        this.userSession = userSession;
    }

    // Helper: parse an int safely, returning null on failure
    private Integer tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Helper: parse a long safely, returning null on failure
    private Long tryParseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String parse(String command) {
        String[] parts = command.split(" ");
        if (parts.length == 0) return "Invalid command format.";
        String action = parts[0];
        String[] args = new String[parts.length - 1];
        System.arraycopy(parts, 1, args, 0, parts.length - 1);

        switch (action) {
            case "Config":
                if (args.length >= 3 && args[0].equals("room") && args[1].equals("count")) {
                    Integer count = tryParseInt(args[2]);
                    if (count == null) return "Invalid room count. Please enter a valid number.";
                    return new ConfigRoomCommand(officeConfig, userSession).execute(count);
                } else if (args.length >= 5 && args[0].equals("room") && args[1].equals("max") && args[2].equals("capacity")) {
                    Integer roomId = tryParseInt(args[3]);
                    Integer capacity = tryParseInt(args[4]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    if (capacity == null) return "Invalid capacity. Please enter a valid number.";
                    return new ConfigRoomMaxCapacityCommand(officeConfig, userSession).execute(roomId, capacity);
                } else if (args.length >= 3 && args[0].equals("release") && args[1].equals("delay")) {
                    Long millis = tryParseLong(args[2]);
                    if (millis == null) return "Invalid delay. Please enter a valid number of milliseconds.";
                    return new src.commands.ConfigReleaseDelayCommand(officeConfig, userSession).execute(millis);
                }
                break;
            case "Add":
                if (args.length >= 3 && args[0].equals("occupant")) {
                    Integer roomId = tryParseInt(args[1]);
                    Integer count = tryParseInt(args[2]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    if (count == null) return "Invalid occupant count. Please enter a valid number.";
                    return new AddOccupantCommand(officeConfig, userSession).execute(roomId, count);
                }
                break;
            case "Remove":
                if (args.length >= 3 && args[0].equals("occupant")) {
                    Integer roomId = tryParseInt(args[1]);
                    Integer count = tryParseInt(args[2]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    if (count == null) return "Invalid occupant count. Please enter a valid number.";
                    return new src.commands.RemoveOccupantCommand(officeConfig, userSession).execute(roomId, count);
                }
                break;
            case "Block":
                if (args.length >= 2 && args[0].equals("room")) {
                    Integer roomId = tryParseInt(args[1]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    String time = args.length > 2 ? args[2] : null;
                    int duration = 60;
                    if (args.length > 3) {
                        Integer d = tryParseInt(args[3]);
                        if (d == null) return "Invalid duration. Please enter a valid number of minutes.";
                        duration = d;
                    }
                    if (time == null) return "Invalid command format. Please provide a time in HH:mm:ss.";
                    return new BlockRoomCommand(officeConfig, userSession).execute(roomId, time, duration);
                }
                break;
            case "Cancel":
                if (args.length >= 2 && args[0].equals("room")) {
                    Integer roomId = tryParseInt(args[1]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    String bookingId = args.length > 2 ? args[2] : null;
                    return new CancelRoomCommand(officeConfig, userSession).execute(roomId, bookingId);
                }
                break;
            case "Status":
                if (args.length >= 2 && args[0].equals("room")) {
                    Integer roomId = tryParseInt(args[1]);
                    if (roomId == null) return "Invalid room id. Please enter a valid number.";
                    return new RoomStatusCommand(officeConfig, userSession).execute(roomId);
                }
                break;
            case "Statistics":
                return new OfficeStatisticsCommand(officeConfig, userSession).execute();
            case "Logout":
                return new UserAuthenticationCommand(officeConfig, userSession).execute();
            case "Me":
                return new UserAuthenticationCommand(officeConfig, userSession).me();
            default:
                return "Invalid command. Please enter a valid command.";
        }
        return "Invalid command format.";
    }
}