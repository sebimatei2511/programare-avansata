import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final Bag bag = new Bag();
    private final Board board = new Board();
    private final MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    private Player winner = new Player("winner");

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

    public synchronized void play() throws InterruptedException {
        for (Player player : players) {
            Thread playerThread = new Thread(() -> {
                System.out.println(player.getName()+" is running");
                player.submitWord();
            });
            playerThread.setDaemon(true);
            playerThread.start();
            Thread.sleep(1000);

            //make the player sleep 50ms; -- from Player.java
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }

        winner.setPoints(0);
        for (Player player : players){
            if (player.getPoints() > winner.getPoints())
                winner = player;
        }
        System.out.println("The game was won by "+winner.getName());
    }

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

    }
}
