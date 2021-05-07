package Sekcja11_KolekcjeIMapy.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        //przy deklaracji można używać: List/Queue/Deque
        Deque<String> d=new LinkedList<>();

        d.addFirst("Black");
        d.addFirst("Red");
        d.addLast("Lila");

        System.out.println(d); //[Red, Black, Lila]
    }
}
