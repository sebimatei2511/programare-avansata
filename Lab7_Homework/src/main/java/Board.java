import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> wordsList = new ArrayList<>();

    public void addWord(Player player, String word) {
        if (MockDictionary.isWord(word)){
            wordsList.add(word);
            System.out.println(player.getName() + ": '" + word + "' with "+ player.getPoints() + " points.");
        }
        else
            System.out.println("This is not a word !!!");
    }

    @Override
    public String toString() {
        return wordsList.toString();
    }
}

