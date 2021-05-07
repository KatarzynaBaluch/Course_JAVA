package Sekcja13_InternacjonalizacjaLokalizacjaCzas;

import java.util.Locale;
import java.util.ResourceBundle;

public class Tlumaczenia {
    public static void main(String[] args) {

        String name = "Kasia";

        Locale.setDefault(new Locale("pl", "PL"));
        ResourceBundle plResourceBundle = ResourceBundle.getBundle("translations");
        System.out.println(plResourceBundle.getString("hello")); //Co słychać?
        System.out.println(String.format(plResourceBundle.getString("hi"), name)); //Cześć Kasia!

        ResourceBundle usResourceBundle = ResourceBundle.getBundle("translations", new Locale("en", "US"));
        System.out.println(usResourceBundle.getString("hello")); //What's up?
        System.out.println(String.format(usResourceBundle.getString("hi"), name)); //Hi Kasia!

    }
}
