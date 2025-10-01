package exercise1.creational.builder;

public class Main {
    public static void main(String[] args) {
        Event techEvent = new Event.EventBuilder("Tech Conference", "2025-10-10")
                .setVenue("Chennai Trade Centre")
                .setSpeaker("Dr. Sundar Rajan")
                .setCapacity(300)
                .build();

        Event birthdayParty = new Event.EventBuilder("Birthday Bash", "2025-11-02")
                .setVenue("Beach Resort")
                .build();

        System.out.println("--- Tech Event ---");
        System.out.println(techEvent);

        System.out.println("\n--- Birthday Party ---");
        System.out.println(birthdayParty);
    }
}
