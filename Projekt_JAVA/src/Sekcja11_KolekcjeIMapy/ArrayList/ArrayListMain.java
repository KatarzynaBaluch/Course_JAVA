package Sekcja11_KolekcjeIMapy.ArrayList;

import Sekcja11_KolekcjeIMapy.PriorityQueue.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {

        String[] array = new String[5];


        //operator diament
        //new - wywołujemy konstruktor, dlatego nawiasy okrągłe, od (chyba) Javy 8 nie trzeba typu w konstruktorze, JAVA sama określi go z deklaracji
        ArrayList<String> l1 = new ArrayList<String>();
        //lepiej chować to pod samym interfejsem List
        //typ nie może być prymitywny
        List<String> l2 = new ArrayList();

        //można też w konstruktorze dodawać liczbę elementów, bd działać szybciej, ale z zasady listy są DYMANICZNE
        List<Integer> l3 = new ArrayList(10);


        //konwersja z tablicy do listy, np;.:
        //1) przeiterować po elementach tablicy i dodać je do listy
        //2) Collections.addAll(kolekcja, tablica)
        //3) Arrays.asList(array) - ale lista staje się NIEMODYFIKOWALNA

        Collections.addAll(l1, array);
        List<String> l4 = Arrays.asList(array); //ale lista NIEMODYFIKOWALNA

        //konwersja listy do tablicy - zwraca tablicę obiektów
        //aby otrzymać konkretny typ - podać go należy przy wywołaniu metody

        l3.toArray(new Integer[]{});

        //_________________________________

        List<String> list = new ArrayList();

        //dodawanie do listy - add - doda na końcu
        list.add("Aa");
        list.add("Bb");
        list.add(0, "Cc");
        list.add("Dd");

        //usuwanie z listy
        //remove - usunie TYLKO pierwsze wystąpienie, aby usunąć wszytskie - należy przeiterować po liście
        list.remove(0);
        list.remove("Aa"); //jesli nie zostanie znaleziony to nic się nie stanie (NIE poleci wyjatek)

        //podstawianie
        list.set(1, "Ee");

        //sortowanie - tylko dla typów implementujących Comparable
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list); //odwraca kolejność

        //czy dany element jest w liście
        list.contains("Bb");

        //rozmiar
        list.size();

        //możemy przechowywać DUPLIKATY I NULLe
        list.add(null);
        list.add("Bb");

        //sublista
        list.subList(0, 2);

        //_________________________________

        List<Person> people = new ArrayList();
        people.add(new Person("Kasia", "123"));
        people.add(new Person("Ala", "454"));

        people.remove(new Person("Kasia", "123")); //ponieważ equels jest przeciążona, nie porównuje domyślnie referencji, to usunie obiekt Kasia 123

        System.out.println(people);

        for (Person person : people) {
            System.out.println(person);
        }


    }
}
