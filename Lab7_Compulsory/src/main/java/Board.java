import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<String> wordsList = new ArrayList<>();

    public void addWord(Player player, String word) {
        wordsList.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return wordsList.toString();
    }
}

