package Sekcja11_KolekcjeIMapy.HashMap;

import java.util.*;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();

        map.put("B", Arrays.asList("Black", "Brown"));
        map.put("P", Arrays.asList("Pink"));
        map.put(null, new ArrayList<>());
        map.put("B", Arrays.asList("Black", "Brown")); //wartość mapy dla klucza "B" zostanie nappisana nową listą

        System.out.println(map);

        //__________________________________________________________

        Map<IntegerKey, String> map2 = new HashMap<>();
        IntegerKey key1 = new IntegerKey(1);
        IntegerKey key2 = new IntegerKey(1); //tu ma byc 1
        IntegerKey key3 = new IntegerKey(3);

        map2.put(key1, "Black");
        map2.put(key2, "Blue");
        map2.put(key3, "Lila");
        //ponieważ nie zostały nadpisane hashcode to domyślnie referencja do obiektów kluczy i dodane zostaną obie pary
        //jeśli nadpiszemy hashcode i uzależnimy od value, to zostanie dodany key1 i potem zostanie napisany, czyli bd jedna pozycja, ktora jako wartosc bd miala "Blue"

        System.out.println(map2);

        //nie można iterowac po mapie, więc
        final Set<Map.Entry<IntegerKey, String>> entries = map2.entrySet();

        for (Map.Entry<IntegerKey, String> entry : entries) {
            entry.getKey();
        }

        System.out.println(map2.get(key1));
        System.out.println("Is map contains key1: " + map2.containsKey(key1)); //true
        System.out.println("Is map contains key2: " + map2.containsKey(key2)); //true
        System.out.println("Is map contains 'Blue' value: " + map2.containsValue("Blue")); //true

        System.out.println(map2.remove(key1)); //Blue
        System.out.println(map2.remove(key3, "Violet")); //false
        System.out.println(map2.remove(key3, "Lila")); //true

        //__________________________________________________________

        Set<Person> people = new HashSet<>();
        people.add(new Person("Nowak", Gender.MALE));
        people.add(new Person("Zielinska", Gender.FEMALE));
        people.add(new Person("Kowalski", Gender.MALE));

        Map<Gender, List<Person>> peopleMap = new HashMap<>();

        for (Person person : people) {
            if (peopleMap.containsKey(person.getGender())) {
                peopleMap.get(person.getGender()).add(person);
            } else {
                List<Person> peoplePerGender = new ArrayList<>();
                peoplePerGender.add(person);
                peopleMap.put(person.getGender(), peoplePerGender);
            }
        }

        System.out.println(peopleMap); //{FEMALE=[Zielinska], MALE=[Nowak, Kowalski]}

        //iterowanie przez same klucze
        for (Gender gender : peopleMap.keySet()) {
            System.out.println(gender); // 1 iteracja "FEMALE", 2 iteracja "MALE"
        }

        //w Javie jest prostszy sposob na wygenerowanie takiej mapy - za pomocą streamów

    }
}
