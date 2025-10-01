package src.models;

import src.observers.RoomObserver;
import java.util.*;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private Map<Integer, Room> rooms;
    private List<RoomObserver> observers;
    private List<String> statistics;
    private long releaseDelayMillis = 5 * 60 * 1000; // default 5 minutes

    private OfficeConfiguration() {
        rooms = new HashMap<>();
        observers = new ArrayList<>();
        statistics = new ArrayList<>();
    }

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public String configureRooms(int count) {
        // Prevent reconfiguration if rooms with bookings exist
        if(count <= 0) {
            return "Invalid room count. Please enter a valid positive number.";
        }
        if (!rooms.isEmpty()) {
            for (Room room : rooms.values()) {
                if (!room.getBookings().isEmpty()) {
                    return "Cannot configure office with " + count + " rooms. Room " + room.getId() + " has bookings.";
                }
            }
            updateStatistics("Office reconfigured with " + count + " meeting rooms");
            rooms.clear(); // clear old rooms if safe
        }

        // Create new rooms
        for (int i = 1; i <= count; i++) {
            rooms.put(i, new Room(i));
        }

        // Build detailed room list
        StringBuilder roomList = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            roomList.append("Room ").append(i);
            if (i < count) {
                roomList.append(", ");
            }
        }
        roomList.append(".");

        // Final message
        String message = "Office configured with " + count + " meeting rooms:\n" + roomList;
        updateStatistics(message);
        return message;
    }

    public String setRoomMaxCapacity(int roomId, int capacity) {
        Room room = rooms.get(roomId);
        if (room == null) {
            return "Room " + roomId + " does not exist.";
        }
        if(capacity < 0) {
            return "Invalid capacity. Please enter a valid positive number.";
        }
        try{
            room.setMaxCapacity(capacity);
        } catch(IllegalArgumentException e) {
            return "Invalid capacity. Please enter a valid positive number.";
        }
        return "Room " + roomId + " max capacity set to " + capacity;
    }

    public Room getRoom(int roomId) {
        return rooms.get(roomId);
    }

    public void addObserver(RoomObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Room room) {
        for (RoomObserver observer : observers) {
            observer.update(room);
        }
    }

    public void updateStatistics(String stat) {
        statistics.add(stat);
    }

    public String getStatistics() {
        if (statistics.isEmpty()) {
            return "No statistics available.";
        }
        return String.join("\n", statistics);
    }

    public long getReleaseDelayMillis() {
        return releaseDelayMillis;
    }

    public void setReleaseDelayMillis(long releaseDelayMillis) {
        this.releaseDelayMillis = releaseDelayMillis;
    }
}
