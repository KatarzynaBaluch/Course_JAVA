package Sekcja11_KolekcjeIMapy.TreeMap;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final String pesel;

    public Person(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return name + "; " + pesel;
    }

    @Override
    public int compareTo(Person o) {
        return this.pesel.compareTo(o.pesel);
    }
}
