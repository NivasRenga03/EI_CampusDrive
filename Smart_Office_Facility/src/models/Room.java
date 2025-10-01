package src.models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Room {
    private int id;
    private int maxCapacity;
    private AtomicInteger occupants; // thread-safe
    private boolean occupied;
    private List<Booking> bookings;

    public Room(int id) {
        this.id = id;
        this.maxCapacity = 0; // 0 means capacity not set
        this.occupants = new AtomicInteger(0);
        this.occupied = false;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking getBookingById(String id) {
        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    public void removeBooking(String id) {
        bookings.removeIf(booking -> booking.getId().equals(id));
    }

    public void clearBookings() {
        bookings.clear();
        occupants.set(0);
        occupied = false;
        turnOffAC();
        turnOffLights();
    }

    public void block(Date start, Date end) {
        Booking booking = new Booking("admin", start, end);
        bookings.add(booking);
        occupied = true;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Max capacity must be non-negative");
        }
        this.maxCapacity = maxCapacity;
        // Automatically mark occupied if current occupants reach max capacity
        if (occupants.get() >= maxCapacity) {
            occupied = true;
            turnOnAC();
            turnOnLights();
        }
    }

    public int getOccupants() {
        return occupants.get();
    }

    // Add occupants safely
    public String addOccupants(int count) {
        if (count < 0) {
            return "Invalid number of occupants. Must be positive.";
        }

        // Require max capacity to be configured before allowing occupants
        if (this.maxCapacity == 0) {
            return "Max capacity for Room " + id + " is not configured. Please configure max capacity before adding occupants.";
        }

        if (count == 0) {
            return "No occupants to add for Room " + id + ".";
        }

        int current = occupants.get();

        // If room already full
        if (current >= maxCapacity) {
            return "Room " + id + " is fully occupied.";
        }

        // If adding these occupants would exceed capacity
        if (current + count > maxCapacity) {
            return "Room " + id + " cannot accommodate " + count + " occupants. Current: " + current + ", Max: " + maxCapacity + ".";
        }

        // Sensor rule: occupancy is only considered when at least 2 people are present
        if (current + count < 2) {
            // update the count but do not mark as occupied or turn on systems
            occupants.addAndGet(count);
            return "Room " + id + " occupancy insufficient to mark as occupied. At least 2 occupants are required.";
        }

        // Otherwise add occupants and mark occupied
        int newCount = occupants.addAndGet(count);
        occupied = true;

        // Automatically turn on AC and lights
        turnOnAC();
        turnOnLights();

        if (newCount >= maxCapacity) {
            return "Room " + id + " is now occupied by " + newCount + " occupants. Room has reached max capacity. AC and lights turned on.";
        }

        return "Room " + id + " is now occupied by " + newCount + " occupants. AC and lights turned on.";
    }

    // Remove occupants safely
    public String removeOccupants(int count) {
        if (count < 0) {
            return "Invalid number of occupants. Must be positive.";
        }

        int newCount = occupants.updateAndGet(old -> Math.max(0, old - count));

        // If the occupancy falls below sensor threshold (2), consider room unoccupied
        if (newCount < 2) {
            // If we were previously occupied, turning off systems and notifying
            if (occupied) {
                occupied = false;
                turnOffAC();
                turnOffLights();
                return "Room " + id + " is now unoccupied. AC and lights turned off.";
            }
            return "Room " + id + " occupancy updated to " + newCount;
        }

        return "Room " + id + " occupancy updated to " + newCount;
    }

    private void turnOnAC() {
        System.out.println("AC turned on for Room " + id);
    }

    private void turnOnLights() {
        System.out.println("Lights turned on for Room " + id);
    }

    private void turnOffAC() {
        System.out.println("AC turned off for Room " + id);
    }

    private void turnOffLights() {
        System.out.println("Lights turned off for Room " + id);
    }
}
