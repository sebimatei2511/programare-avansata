import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    //private final MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() {
        for (Player player : players) {
            Thread playerThread = new Thread(() -> {
                System.out.println(player.getName()+" is running");
                player.submitWord();
            });
            playerThread.start();

            //make the player sleep 50ms; -- from Player.java
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
