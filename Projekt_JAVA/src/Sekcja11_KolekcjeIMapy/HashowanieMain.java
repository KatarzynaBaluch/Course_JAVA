package Sekcja11_KolekcjeIMapy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashowanieMain {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();

        list.add("Black");
        list.add("Pink");
        list.add("White");
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Orange");
        list.add("Gray");

        System.out.println(list.contains("Gray")); //8 elemetów(iteracji) + 8 sprawdzeń equals

        //hashowanie

        List<String>[] arrayOfLists=new ArrayList[10];

        //ile liter taki indeks
        arrayOfLists[2]= Arrays.asList("Red");
        arrayOfLists[3]= Arrays.asList("Pink", "Blue", "Gray");
        arrayOfLists[4]= Arrays.asList("Black", "White","Green");
        arrayOfLists[5]= Arrays.asList("Orange");

        System.out.println(arrayOfLists["Gray".length()].contains("Gray")); //3 iteracje + 3 sprawdzenia equals
    }
}
