package exercise1.behaviour.observer;

public class Main {
    public static void main(String[] args) {
        ICUPatient patient = new ICUPatient("John Doe", 80, "120/80", 16);

        DoctorObserver doctor = new DoctorObserver("Smith");
        NurseObserver nurse = new NurseObserver("Alice");
        FamilyObserver spouse = new FamilyObserver("Spouse");

        // register observers
        patient.registerObserver(doctor);
        patient.registerObserver(nurse);
        patient.registerObserver(spouse);

        System.out.println("---- Initial ICU Monitoring ----");
        patient.notifyObservers();

        System.out.println("\n---- Heart Rate Change ----");
        patient.setHeartRate(50);

        System.out.println("\n---- Blood Pressure Change ----");
        patient.setBloodPressure("150/100");

        System.out.println("\n---- Respiratory Rate Change ----");
        patient.setRespiratoryRate(25);
    }
}
