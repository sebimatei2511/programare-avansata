package com;

import java.util.Locale;
import java.text.SimpleDateFormat;

public class DisplayLocales {

    public static void DisplayAll() {

        Locale[] locales = SimpleDateFormat.getAvailableLocales();

        for (Locale locale : locales) {

            System.out.printf("%10s - %s, %s \n", locale.toString(),
                    locale.getDisplayName(), locale.getDisplayCountry());

        }
    }
}
