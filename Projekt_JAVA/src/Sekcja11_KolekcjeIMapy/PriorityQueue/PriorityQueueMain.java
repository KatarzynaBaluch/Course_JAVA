package Sekcja11_KolekcjeIMapy.PriorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMain {
    public static void main(String[] args) {
        Queue<String> q1=new PriorityQueue<>();

        q1.add("Blue");
        q1.add("Red");
        q1.add("Black");

        q1.offer("White"); //w przypadku kolejek z zadeklarowanym rozmiarem, gdy bd już całkowicie wypełniona z offer poleci false

        //iterator
        Iterator<String> it=q1.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        //dla kolejek można też użyć while
        while (q1.isEmpty())
        {
            //System.out.println(q1.peek()); //jesli bd pusta to wyjdzie null
            System.out.println(q1.element()); //w przypadku braku poleci wyjątek
        }

        //komparator można od razu odwrócic, żeby sortowanie bylo przeciwne
        Queue<Person> people=new PriorityQueue<>(new PersonComparator().reversed());
        people.add(new Person("Adam", "443"));
        people.add(new Person("John", "123"));

        System.out.println(people);

    }
}
