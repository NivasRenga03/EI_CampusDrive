package exercise1.behaviour.command;

public class RewindCommand implements Command {
    private YouTubePlayer player;

    public RewindCommand(YouTubePlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.rewind();
    }
}
