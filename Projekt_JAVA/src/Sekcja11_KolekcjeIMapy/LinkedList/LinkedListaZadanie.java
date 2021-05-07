package Sekcja11_KolekcjeIMapy.LinkedList;

import java.util.Deque;
import java.util.LinkedList;


public class LinkedListaZadanie {
    static class QueueToDeansOffice {

        private Deque<String> kolejka=new LinkedList<>();
        public void addStudent(String name) {
            System.out.println(name+ " staje w kolejce.");
            this.kolejka.addFirst(name);
        }

        public void handleNextStudent() {
            System.out.println(this.kolejka.removeLast()+ " zostal obsluzony.");
        }

        public void removeStudent(String name) {
            System.out.println(name+ " rezygnuje z czekania.");
            this.kolejka.remove(name);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację kolejki do dziekanatu. Studenci staja na końcu kolejki.
         * Zniecierpliwiony student, może w każdej chwili opuścić kolejkę.
         */

        QueueToDeansOffice queue = new QueueToDeansOffice();
        queue.addStudent("Kowalski");
        queue.addStudent("Zielinski");
        queue.handleNextStudent();
        queue.addStudent("Panna");
        queue.removeStudent("Zielinski");
        queue.handleNextStudent();

//        Kowalski staje w kolejce.
//        Zielinski staje w kolejce.
//        Kowalski został obsłużony.
//        Panna staje w kolejce.
//        Zielinski rezygnuje z czekania.
//        Panna został obsłużony.
    }

}
