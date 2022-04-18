import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MockDictionary {

    static Set<String> wordsList;

    MockDictionary(){
        wordsList=new HashSet<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/create.txt"))){
            String line;
            while((line=bufferedReader.readLine())!=null)
                wordsList.add(line.toUpperCase());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean isWord(String str) {
        return wordsList.contains(str);
    }

    public static Set<String> getWordsList(){
        return wordsList;
    }
}

