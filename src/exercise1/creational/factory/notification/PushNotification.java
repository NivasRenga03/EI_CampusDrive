package exercise1.creational.factory;

public class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("🔔 Sending a Push notification");
    }
}
