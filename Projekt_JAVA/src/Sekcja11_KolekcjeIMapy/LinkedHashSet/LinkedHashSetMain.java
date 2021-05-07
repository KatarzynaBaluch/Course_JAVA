package Sekcja11_KolekcjeIMapy.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        //pod spodem - zachowana kolejnosc bucketow
        set.add("Black");
        set.add("Red");

        for (String color : set) {
            System.out.println(color);
        }
    }
}
