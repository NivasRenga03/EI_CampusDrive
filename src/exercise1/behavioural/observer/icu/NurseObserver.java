package exercise1.behaviour.observer;

public class NurseObserver implements ICUObserver {
    private String name;

    public NurseObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String patientName, int heartRate, String bloodPressure, int respiratoryRate) {
        System.out.println("Nurse " + name + " notified: " + patientName +
                " | HR: " + heartRate + ", BP: " + bloodPressure + ", RR: " + respiratoryRate);
    }
}
