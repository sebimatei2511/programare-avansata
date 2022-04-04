import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    private final List<Tile> tilesList = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            for (int index = 1; index <= 10; index++){
                Random random = new Random();
                Tile newTile = new Tile(c,random.nextInt(10 - 1 + 1) + 1);
                tilesList.add(newTile);
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tilesList.isEmpty()) {
                break;
            }
            Random rand = new Random();
            Tile randomElement = tilesList.get(rand.nextInt(tilesList.size()));
            extracted.add(randomElement);
        }
        return extracted;
    }
}
