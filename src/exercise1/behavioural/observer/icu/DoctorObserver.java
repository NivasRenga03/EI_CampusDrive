package exercise1.behaviour.observer;

public class DoctorObserver implements ICUObserver {
    private String name;

    public DoctorObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String patientName, int heartRate, String bloodPressure, int respiratoryRate) {
        System.out.println("Doctor " + name + " notified: " + patientName +
                " | HR: " + heartRate + ", BP: " + bloodPressure + ", RR: " + respiratoryRate);
    }
}
