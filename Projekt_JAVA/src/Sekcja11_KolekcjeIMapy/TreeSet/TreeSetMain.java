package Sekcja11_KolekcjeIMapy.TreeSet;

import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {

        //implementacja treeSet NIE UŻYWA HASHOWANIA
        //obiekty muszą implementowąc Comparable lub musi być Comparator

        Set<String> set = new TreeSet<>();

        set.add("Pink");
        set.add("Black");
        set.add("Green");

        System.out.println(set); //[Black, Green, Pink]
        //dla zwyklego Seta nie ma first, last
        //System.out.println(set.first());

        //_________________________________________________________

        //TreeSet implementuje: NavigableSet i SortedSet - mają ciekawe metody

        NavigableSet<String> colors = new TreeSet<>();

        colors.add("Pink");
        colors.add("Black");
        colors.add("Green");
        colors.add("Violet");

        System.out.println(colors.higher("B")); //pierwszy "większy" od "B" - Black

        System.out.println(colors.higher("Black")); //większy od - Green
        System.out.println(colors.ceiling("Black")); //większy lub równy - Black

        System.out.println(colors.lower("H")); //Green
        System.out.println(colors.subSet("Black", "Pink")); //[Black, Green]
        System.out.println(colors.subSet("B", "P")); //[Black, Green]
        System.out.println(colors.headSet("C")); //wszystkie przed C, [Black]
        System.out.println(colors.tailSet("G")); //[Green, Pink, Violet]

        //nie ma metody get, ale są first i last
        System.out.println(colors.first());
        System.out.println(colors.last());

    }
}
