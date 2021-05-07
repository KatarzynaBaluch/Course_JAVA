package Sekcja11_KolekcjeIMapy.PriorityQueue;

import java.util.Objects;

public class Person implements Comparable<Person>{
    //Comparable - generyczny - jak nie damy typów <> to bd Object
    private final String name;
    private final String pesel;

    public Person(String name, String pesel) {
        this.name = name;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(pesel, person.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pesel);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.pesel.compareTo(o.pesel);
    }
}
