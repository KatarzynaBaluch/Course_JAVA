package Sekcja11_KolekcjeIMapy.TreeSet;

import java.util.*;

public class TreeSetZadanie {
    static class Application implements Comparable<Application> {
        final String name;
        final Integer points;

        Application(String name, Integer points) {
            this.name = name;
            this.points = points;
        }

        @Override
        public String toString() {
            return "\n" + name + " " + points;
        }

        @Override
        public int compareTo(Application o) {
            if (o.points.compareTo(this.points) != 0) { //zeby punkty byly malejaco
                return o.points.compareTo(this.points);
            }
            return this.name.compareTo(o.name);
        }
    }

    static class NameComparator implements Comparator<Application> {

        @Override
        public int compare(Application o1, Application o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    static class ApplicationList extends TreeSet<Application> {

        void printList() {
            SortedSet<Application> sorted = this.headSet(new Application("", 200));
            NavigableSet<Application> subSetK = new TreeSet<>(new NameComparator());
            subSetK.addAll(sorted);
            System.out.println(subSetK.subSet(new Application("K", 0), new Application("L", 0)));
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację listy zgłoszeń na studia dzienne.
         * O kolejnosci decyduje liczba punktów.
         * Wyświetl listę wszystkich aplikantów zaczynających się na literę K, spośród mających conajmniej 200 pkt.
         * Stwórz klasę ApplicationList, która dziedziczy po odpowiedniej kolekcji.
         */
        ApplicationList applicationList = new ApplicationList();
        applicationList.add(new Application("Kowalski", 100));
        applicationList.add(new Application("Zieliński", 299));
        applicationList.add(new Application("Kania", 501));
        applicationList.add(new Application("Orzeł", 500));
        applicationList.add(new Application("Kwiatkowiski", 500));
        applicationList.printList();

        // Kania
        // Kwiatkowiski

    }

}
