package exercise1.behaviour.command;

public class PlayCommand implements Command {
    private YouTubePlayer player;

    public PlayCommand(YouTubePlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
