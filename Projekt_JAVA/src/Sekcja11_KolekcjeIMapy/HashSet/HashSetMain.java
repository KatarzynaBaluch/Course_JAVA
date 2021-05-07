package Sekcja11_KolekcjeIMapy.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Black");
        set.add("Pink");
        set.add("White");
        set.add("Red");
        set.add("Blue");
        set.add("Green");
        set.add("Orange");
        set.add("Gray");
        set.add("Gray"); // w srodku tej metody wywolany zostanie contains > poleci true, wiec nie zostanie dodany

        //dla stringów domyslny hashcode unikalny dla kazdego stringa - każdy ma swój bucket

        System.out.println(set.contains("Gray")); //1 operacja (wejscie do odpowiedniego bucketa) + 1 sprawdzenie equals (w tym buckecie)

        //iterowanie po hashSet
        //for
        for (String string : set) {
            System.out.println(string);
        }

        //iterator
        Iterator<String> it = set.iterator();
        while (!it.hasNext()) {
            it.next();
        }

    }
}
