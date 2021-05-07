package Sekcja11_KolekcjeIMapy.PriorityQueue;

import Sekcja11_KolekcjeIMapy.PriorityQueue.Person;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getPesel().compareTo(o2.getPesel());
    }
}
