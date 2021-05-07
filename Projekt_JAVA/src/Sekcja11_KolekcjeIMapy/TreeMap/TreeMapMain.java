package Sekcja11_KolekcjeIMapy.TreeMap;

import java.util.NavigableMap;

public class TreeMapMain {
    public static void main(String[] args) {
        //sortowanie po kluczach

        NavigableMap<String, String> map = new java.util.TreeMap<>();

        map.put("Red", null);
        map.put("Blue", null);
        map.put("Pink", null);

        System.out.println(map); //{Blue=null, Pink=null, Red=null}

        //nie ma hashowania

        //-------------------------------------------------------

        NavigableMap<Person, String> people=new java.util.TreeMap<>();

        people.put(new Person("Adam", "123"),null);
        people.put(new Person("Barbara", "123"),null);
        people.put(new Person("Jan", "456"),null);

        System.out.println(people); //{Adam; 123=null, Jan; 456=null}, bo w person compare to zalezy od peselu - element nie został dodany, bo już taki element istnieje

    }
}