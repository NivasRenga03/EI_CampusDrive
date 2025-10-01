package exercise1.structural.facade;

// Facade that simplifies overseas travel booking
public class TravelAgentFacade {
    private TicketBooking ticketBooking;
    private VisaProcessing visaProcessing;
    private Lodging lodging;
    private LocalTransport transport;
    private SightSeeing sightseeing;

    public TravelAgentFacade() {
        this.ticketBooking = new TicketBooking();
        this.visaProcessing = new VisaProcessing();
        this.lodging = new Lodging();
        this.transport = new LocalTransport();
        this.sightseeing = new SightSeeing();
    }

    public void bookOverseasTrip(String from, String to) {
        System.out.println("----- Starting Overseas Trip Booking -----");
        visaProcessing.applyVisa(to);
        ticketBooking.bookTickets(from, to);
        lodging.bookHotel(to);
        transport.bookTransport(to);
        sightseeing.arrangeTours(to);
        System.out.println("----- Overseas Trip Booking Completed Successfully! -----");
    }
}
