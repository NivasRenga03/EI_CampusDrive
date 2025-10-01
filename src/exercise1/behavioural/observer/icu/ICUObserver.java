package exercise1.behaviour.observer;

public interface ICUObserver {
    void update(String patientName, int heartRate, String bloodPressure, int respiratoryRate);
}
