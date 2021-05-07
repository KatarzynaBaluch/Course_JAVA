package Sekcja13_InternacjonalizacjaLokalizacjaCzas;

import javax.sound.midi.Soundbank;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Internacjonalizacja {
    public static void main(String[] args) {

        double dbl = 3100.0;
        String us = "3,1000.0";
        String de = "3.100,0";

        LocalDate date = LocalDate.of(2020, 02, 10);
        String usDate = "2020 February 10";
        String plDate = "10 luty 2020";

        double price = 1000;
        String usPrice = "$1000.0";
        String plPrice = "1000 zł";


        //______________________________

        System.out.println(Locale.getDefault()); //pl_PL jaki ustawiony domyslnie

        Locale locale1 = new Locale.Builder()
                .setLanguage("pl")
                .setRegion("PL")
                .build();
        Locale locale2 = Locale.US;
        Locale locale3 = Locale.forLanguageTag("en-PL");

        Locale.setDefault(locale2);
        System.out.println(Locale.getDefault()); //en_US

        //________________________________

        NumberFormat defaultNumberFormat = NumberFormat.getInstance();
        NumberFormat deNumberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);

        double d = 1000.01;

        System.out.println(defaultNumberFormat.format(d)); //1,000.01
        System.out.println(deNumberFormat.format(d)); //1.000,01

        NumberFormat defaultCurrencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat deCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);

        System.out.println(defaultCurrencyFormat.format(d)); //$1,000.01
        System.out.println(deCurrencyFormat.format(d)); //1.000,01 €

        //___________________________________

        System.out.println(Month.MARCH.getDisplayName(TextStyle.SHORT, Locale.GERMANY)); //März
        System.out.println(DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL, Locale.GERMANY)); //Mittwoch

        //___________________________________

        LocalDateTime localDateTime = LocalDateTime.now();
        String pattern = "dd-MMMM-yyyy; HH:mm::ss.SSS";
        DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter deDateTimeFormatter = DateTimeFormatter.ofPattern(pattern, Locale.GERMANY);

        System.out.println(myDateTimeFormatter.format(localDateTime)); //30-December-2020; 14:10::41.695
        System.out.println(deDateTimeFormatter.format(localDateTime)); //30-Dezember-2020; 14:10::41.695

    }
}
