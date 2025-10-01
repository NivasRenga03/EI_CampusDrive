package exercise1.behaviour.command;

public class Main {
    public static void main(String[] args) {
        YouTubePlayer player = new YouTubePlayer();

        Command play = new PlayCommand(player);
        Command pause = new PauseCommand(player);
        Command rewind = new RewindCommand(player);

        YouTubeAppUI appUI = new YouTubeAppUI();

        System.out.println("🎬 --- YouTube Command Pattern Demo ---");

        appUI.setCommand(play);
        appUI.clickButton();

        appUI.setCommand(pause);
        appUI.clickButton();

        appUI.setCommand(rewind);
        appUI.clickButton();
    }
}
