package exercise1.behaviour.observer;

public class FamilyObserver implements ICUObserver {
    private String relation;

    public FamilyObserver(String relation) {
        this.relation = relation;
    }

    @Override
    public void update(String patientName, int heartRate, String bloodPressure, int respiratoryRate) {
        System.out.println("Family (" + relation + ") notified: " + patientName +
                " | HR: " + heartRate + ", BP: " + bloodPressure + ", RR: " + respiratoryRate);
    }
}
