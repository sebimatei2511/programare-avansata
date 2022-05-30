import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    public static void main( String[] args ) throws IOException {
        DisplayLocales.DisplayAll();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        SetLocale.Set(bufferedReader);

        System.out.println(Locale.getDefault());

        Info.getInfo(Locale.getDefault());

    }
}
