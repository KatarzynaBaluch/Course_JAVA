package Sekcja11_KolekcjeIMapy.HashMap;

import java.util.*;

public class RegisterZadanie {
    static class RegistrationManager {
        private final Map<String, Set<String>> map = new HashMap<>();

        public void register(String className, String studentName) {
            if (map.containsKey(className)) {
                map.get(className).add(studentName);
            } else {
                Set<String> names = new TreeSet<>();
                names.add(studentName);
                map.put(className, names);
            }
        }

        public void printStudents(String className) {
            System.out.println(map.get(className));
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację systemu zapisów na wykłady.
         * System ma błąd i pozwala, żeby student mógł zapisać się wielokrotnie na ten sam wykład.
         * Zapisy muszą działać w taki sposób, żeby dostęp do listy wszystkich studentów dla danego wykładu był szybki,
         * a lista zwracanych studentów unikalna i posortowana alfabetycznie.
         */
        RegistrationManager manager = new RegistrationManager();
        manager.register("Analiza matematyczna", "Kowalski");
        manager.register("Analiza matematyczna", "Zieliński");
        manager.register("Algebra", "Kowalski");
        manager.register("Analiza matematyczna", "Kowalski");
        manager.register("Analiza matematyczna", "Cebula");

        manager.printStudents("Analiza matematyczna");

        // [Cebula, Kowalski, Zieliński]
    }

}
