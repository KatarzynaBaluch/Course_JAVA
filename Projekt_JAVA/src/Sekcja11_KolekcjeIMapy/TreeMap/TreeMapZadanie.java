package Sekcja11_KolekcjeIMapy.TreeMap;

import java.util.*;
import java.util.TreeMap;

public class TreeMapZadanie {
    static class Dictionary {

        NavigableMap<String, NavigableSet<String>> dict = new TreeMap<>();

        public Dictionary(Set<String> words) {

            for (String word : words) {
                String letter = word.substring(0, 1).toLowerCase();
                if (dict.containsKey(letter)) {
                    dict.get(letter).add(word.toLowerCase());
                } else {
                    NavigableSet<String> set = new TreeSet<>(Comparator.reverseOrder());
                    set.add(word.toLowerCase());
                    dict.put(letter, set);
                }
            }
        }

        public void printWordsByLetter(String letter) {
            System.out.println(dict.get(letter.toLowerCase()));
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację prostego słownika.
         * Słownik powinien być posortowany alfabetycznie.
         * Zależy nam, na szybkim dostępie do wszystkich słów dla danej litery.
         * Napisz metodę drukującą wszystkie słowa,
         * zaczynające się od danej litery, w odwrotnej kolejności.
         * Uwaga na małe i duże litery!
         */
        Set<String> words = Set.of(
                "kopytko",
                "Kapusta",
                "ananas",
                "pomarańcza",
                "Kiwi",
                "kalafior"
        );
        Dictionary manager = new Dictionary(words);
        manager.printWordsByLetter("K");

        // [kopytko, kiwi, kapusta, kalafior]
    }

}
