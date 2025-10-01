package exercise1.structural.facade;

public class Main {
    public static void main(String[] args) {
        TravelAgentFacade travelAgent = new TravelAgentFacade();
        travelAgent.bookOverseasTrip("Chennai", "Paris");
    }
}
