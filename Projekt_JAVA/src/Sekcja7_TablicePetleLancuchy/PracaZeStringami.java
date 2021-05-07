package Sekcja7_TablicePetleLancuchy;

import java.util.StringJoiner;

public class PracaZeStringami {
    public static void main (String[] args)
    {
        String car="Ford";
        car="Ford"+" Mustang";

        System.out.println("_______________________________________________________");
        //"dynamiczny" string
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("Ford").append(" Mustang").toString();

        String test="Na górze róże. Na dole fiołki.";
        String[] testArray=test.split(" ");
        for(String element : testArray)
        {
            System.out.println(element);
        }

        //żeby to tak na serio oddzielić
        for (String sentence: test.split("\\.")) { //. - znak specjalny dlatego //
            for (String word : sentence.split(" ")) {
                System.out.println(word);
            }
        }

        System.out.println("____________________________________________________");
        //połaćznie elementow tablicy do stringa
        //zeby wyswietlic: red, green, blue
        String stringJoin=String.join(",","red","green", "blue");
        System.out.println("stringJoin: "+stringJoin);

        //zeby wyswietlic
        StringJoiner stringJoiner=new StringJoiner(", ","[","]");
        stringJoiner.add("red").add("green").add("blue");
        System.out.println("stringJoiner: "+stringJoiner);

        System.out.println("____________________________________________________");
        String s="I'm happy";
        System.out.println(s.contains("happy"));

        System.out.println(s.contains("HAPPY"));

        System.out.println(s.toUpperCase().contains("HAPPY"));

        System.out.println("____________________________________________________");
        System.out.println("index h: "+ s.indexOf('h'));
        System.out.println("index happy: "+ s.indexOf("happy"));

        System.out.println("____________________________________________________");
        System.out.println(s.substring(0,s.indexOf('h')));

        System.out.println("____________________________________________________");
        System.out.println("       Hi".trim());

        System.out.println("____________________________________________________");
        System.out.println(s.replace("happy", "unhappy"));


    }
}
