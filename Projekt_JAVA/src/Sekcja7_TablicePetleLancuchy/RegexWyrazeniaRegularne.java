package Sekcja7_TablicePetleLancuchy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexWyrazeniaRegularne {
    public static void main(String[] args)
    {
        //Pattern pattern =Pattern.compile("a");//wzorzec - pojedyncza litera
        //Pattern pattern =Pattern.compile("[am]"); //wzorzec pojedyncze litery
        //Pattern pattern =Pattern.compile("[am].."); //wzorzec literka + 2 znaki
        //Pattern pattern =Pattern.compile("[am]?"); //wzorzec ? zero albo jedno wystapienie
        //Pattern pattern =Pattern.compile("[am]+"); //wzorzec jedno lub wiele wystapien
        Pattern pattern =Pattern.compile("[a-zA-Z\\.\\s]+"); //małe i wielkie litery, kropka, spacja (\\s)



        Matcher matcher= pattern.matcher("Ala ma kota"); //czy bd pasowal do wzorca

        int matches=0;
        while(matcher.find())
        {
            matches++;
        }
        System.out.println(matches);
        System.out.println(matcher.matches()); //czy spelnia wymagania patternu (lin 14)
        //można też tak:
        System.out.println("Ala ma kota.".matches("[a-zA-z\\.\\s]"));





    }
}
