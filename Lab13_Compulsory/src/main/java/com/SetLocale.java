package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
public class SetLocale {

    static int switcher = 0;
    static MessageFormat messageFormat = new MessageFormat("{0, number, #}");
    public static void Set(BufferedReader bufferedReader) throws IOException {


        Locale[] locales = SimpleDateFormat.getAvailableLocales();

        System.out.println("Please enter the locale for the application:");

        messageFormat.setLocale(new Locale(bufferedReader.readLine()));
        Locale locale = messageFormat.getLocale();

        for (Locale value : locales)
            if (locale.toString().equals(value.toString())) {
                System.out.println("Locale is: " + locale);
                switcher = 1;
                Locale.setDefault(locale);
            }
        if (switcher == 0)
            System.out.println("Unknown locale. Please try again.");

    }
}
