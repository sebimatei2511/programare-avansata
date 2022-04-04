import java.util.List;

public class Player implements Runnable {
    private final String name;
    private Game game;
    //private boolean running;

    public Player(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return;
        }
        //create a word with all the extracted tiles;
        StringBuilder word = new StringBuilder();
        for (Tile tile : extracted) {
            word.append(tile.getLetter());
        }

        game.getBoard().addWord(this, word.toString());

        //make the player sleep 50ms;

    }

    @Override
    public void run() {

    }
}
