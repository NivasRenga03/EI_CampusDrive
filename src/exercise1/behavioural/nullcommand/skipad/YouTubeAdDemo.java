package exercise1.behaviour.nullcommand;

public class YouTubeAdDemo {
    public static void main(String[] args) throws InterruptedException {
        SkipAdButton skipButton = new SkipAdButton();

        // First 5 seconds -> NullCommand
        for (int i = 1; i <= 5; i++) {
            System.out.print("Second " + i + " → ");
            skipButton.click();
            Thread.sleep(1000); // wait 1 second
        }

        // After 5 seconds -> Enable SkipCommand
        System.out.println("\n--- Skip button is now enabled ---\n");
        skipButton.setCommand(new SkipCommand());

        // Clicking after 5 seconds
        skipButton.click();
    }
}
