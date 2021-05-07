package Sekcja11_KolekcjeIMapy.LinkedHashMap;

import java.util.ArrayDeque;

public class LinkedHashMapZadanie {
    static class BrowserHistory {
        private final Cache cache = new Cache(3);

        public void browse(String site) {
            cache.put(site, null);
        }

        public void print() {
            ArrayDeque<String> deque = new ArrayDeque<>();
            for (String key : cache.keySet()) {
                deque.addFirst(key);
            }
            System.out.println(deque);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację historii przeglądarki, pamiętającą 3 ostatnich przeglądanych stron internetowych.
         * Wyświetl historię przeglądarki, ale w kolejnosci od ostatnio przegladanej strony.
         */
        BrowserHistory manager = new BrowserHistory();
        manager.browse("onet.pl");
        manager.browse("interia.pl");
        manager.browse("gazeta.pl");
        manager.browse("onet.pl");
        manager.browse("pudelek.pl");
        manager.browse("plotka.pl");

        manager.print();

        // [plotka.pl, pudelek.pl, onet.pl]
    }

}
