package exercise1.behaviour.observer;

import java.util.ArrayList;
import java.util.List;

public class ICUPatient {
    private String name;
    private int heartRate;
    private String bloodPressure;
    private int respiratoryRate;

    private List<ICUObserver> observers = new ArrayList<>();

    public ICUPatient(String name, int heartRate, String bloodPressure, int respiratoryRate) {
        this.name = name;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.respiratoryRate = respiratoryRate;
    }

    public void registerObserver(ICUObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ICUObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ICUObserver observer : observers) {
            observer.update(name, heartRate, bloodPressure, respiratoryRate);
        }
    }

    // setters that notify observers
    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
        notifyObservers();
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
        notifyObservers();
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
        notifyObservers();
    }
}
