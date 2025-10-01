package exercise1.behaviour.nullcommand;

public class SkipCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Ad skipped! Back to the video 🎬");
    }
}
