package com;

import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

import static java.util.Currency.getInstance;

public class Info {

    public static void getInfo(Locale locale) {

        LocalDate today = LocalDate.now();


        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println();

        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println();


        //System.out.println("Currency: " + Currency.getInstance(locale));
        //System.out.println();

        System.out.println("Week Days: " + Arrays.toString(
                DateFormatSymbols.getInstance(locale).getWeekdays()));
        System.out.println();

        System.out.println("Months:" + Arrays.toString(
                DateFormatSymbols.getInstance(locale).getMonths()));
        System.out.println();

        System.out.println("Today: " + today.getMonth() + " " + today.getDayOfMonth() + " " + today.getYear());

    }

}
