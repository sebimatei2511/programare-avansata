import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player implements Runnable {
    private final String name;
    private Game game;
    private boolean running;
    private int points;

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

        Collections.shuffle(extracted);

        //create a word with all the extracted tiles;
        StringBuilder sb = new StringBuilder();
        for (Tile tile : extracted) {
            sb.append(tile.getLetter());
        }

        StringBuilder word = new StringBuilder(sb.toString());

        while(!MockDictionary.isWord(word.toString())){
            String string = sb.toString();
            List<String> charactersList = Arrays.asList(string.split(""));
            Collections.shuffle(charactersList);
            word = new StringBuilder();

            for ( String character : charactersList ){
                word.append(character);
            }

            StringBuilder buffer = new StringBuilder(word.toString());

            while( buffer.length() != 1 || !MockDictionary.isWord(buffer.toString())){
                buffer.deleteCharAt(buffer.length()-1);
                if (MockDictionary.isWord(buffer.toString()))
                    break;
            }

            word = new StringBuilder(buffer.toString());
        }

        points = 0;
        for (int index = 0; index < word.length(); index++){
            for (Tile tile : extracted){
                if (word.charAt(index) == tile.getLetter()){
                    points += tile.getPoints();
                    break;
                }
            }
        }
        points *= word.length();

        game.getBoard().addWord(this, word.toString());

        //make the player sleep 50ms;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
        submitWord();
    }
}
