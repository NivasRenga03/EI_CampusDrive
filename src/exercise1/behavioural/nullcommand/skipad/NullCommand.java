package exercise1.behaviour.nullcommand;

public class NullCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Skip Ad not available yet...");
    }
}
