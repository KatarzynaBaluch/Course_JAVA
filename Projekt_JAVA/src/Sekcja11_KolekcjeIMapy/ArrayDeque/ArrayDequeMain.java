package Sekcja11_KolekcjeIMapy.ArrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeMain {
    public static void main(String[] args) {
        Deque<String> fifo=new ArrayDeque<>();
        Deque<String> lifo=new ArrayDeque<>();

        //FIFO - first in, first out
        fifo.addFirst("one");
        fifo.addFirst("two");

        System.out.println(fifo.pollLast()); //one


        //LIFO - last in, first out - STOS
        fifo.addFirst("one");
        fifo.addFirst("two");

        System.out.println(fifo.pollFirst()); //two
    }
}
