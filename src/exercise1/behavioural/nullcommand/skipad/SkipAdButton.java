package exercise1.behaviour.nullcommand;

public class SkipAdButton {
    private Command command;

    // Initially the button has NullCommand
    public SkipAdButton() {
        this.command = new NullCommand();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        command.execute();
    }
}
