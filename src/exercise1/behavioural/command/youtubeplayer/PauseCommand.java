package exercise1.behaviour.command;

public class PauseCommand implements Command {
    private YouTubePlayer player;

    public PauseCommand(YouTubePlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
