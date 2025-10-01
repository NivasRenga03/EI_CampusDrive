package exercise1.behaviour.command;

public class YouTubeAppUI {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void clickButton() {
        if (command != null) {
            command.execute();
        }
    }
}
