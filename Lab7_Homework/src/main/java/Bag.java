import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    private final List<Tile> tilesList = new ArrayList<>();
    Tile tile;


    //create the bag by adding a specific number o tiles for each letter
    //and a specific number of points for each
    public Bag() {
        for (int index = 1; index <= 12; index ++){
            if (index <= 1){
                tile = new Tile('J',8);
                tilesList.add(tile);
                tile = new Tile('K',5);
                tilesList.add(tile);
                tile = new Tile('Q',10);
                tilesList.add(tile);
                tile = new Tile('X',8);
                tilesList.add(tile);
                tile = new Tile('Z',10);
                tilesList.add(tile);
            }

            if (index <= 2){
                tile = new Tile('B',3);
                tilesList.add(tile);
                tile = new Tile('C',3);
                tilesList.add(tile);
                tile = new Tile('F',4);
                tilesList.add(tile);
                tile = new Tile('H',4);
                tilesList.add(tile);
                tile = new Tile('M',3);
                tilesList.add(tile);
                tile = new Tile('P',3);
                tilesList.add(tile);
                tile = new Tile('V',4);
                tilesList.add(tile);
                tile = new Tile('W',4);
                tilesList.add(tile);
                tile = new Tile('Y',4);
                tilesList.add(tile);
            }

            if (index <= 3){
                tile = new Tile('G',2);
                tilesList.add(tile);
            }

            if (index <= 4){
                tile = new Tile('D',2);
                tilesList.add(tile);
                tile = new Tile('L',1);
                tilesList.add(tile);
                tile = new Tile('S',1);
                tilesList.add(tile);
                tile = new Tile('U',1);
                tilesList.add(tile);
            }

            if (index <= 6){
                tile = new Tile('N',1);
                tilesList.add(tile);
                tile = new Tile('T',1);
                tilesList.add(tile);
                tile = new Tile('R',1);
                tilesList.add(tile);
            }

            if (index <= 8){
                tile = new Tile('O',1);
                tilesList.add(tile);
            }

            if (index <= 9){
                tile = new Tile('A',1);
                tilesList.add(tile);
                tile = new Tile('I',1);
                tilesList.add(tile);
            }

            tile = new Tile('E',1);
            tilesList.add(tile);
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
