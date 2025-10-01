package exercise1.creational.builder;

public class Event {
    private String name;
    private String date;
    private String venue;
    private String speaker;
    private int capacity;

    private Event(EventBuilder builder) {
        this.name = builder.name;
        this.date = builder.date;
        this.venue = builder.venue;
        this.speaker = builder.speaker;
        this.capacity = builder.capacity;
    }

    public static class EventBuilder {
        private String name;
        private String date;
        private String venue;
        private String speaker;
        private int capacity;

        public EventBuilder(String name, String date) {
            this.name = name;
            this.date = date;
        }

        public EventBuilder setVenue(String venue) {
            this.venue = venue;
            return this;
        }

        public EventBuilder setSpeaker(String speaker) {
            this.speaker = speaker;
            return this;
        }

        public EventBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }

    @Override
    public String toString() {
        return "Event Details: " +
                "\nName: " + name +
                "\nDate: " + date +
                "\nVenue: " + (venue != null ? venue : "Not Decided") +
                "\nSpeaker: " + (speaker != null ? speaker : "Not Decided") +
                "\nCapacity: " + capacity;
    }
}
