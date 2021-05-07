package Sekcja11_KolekcjeIMapy.HashSet;

import java.util.Arrays;
import java.util.List;

public class HashSetZadanie {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację bilbioteki. Wypożyczjący mogą sprawdzić czy książka o danym isbn istnieje.
         * Mogą ją wypożyczyć i zwrócić. Biblioteka powinna pamiętać również wypożyczone książki.
         */
        List<Book> books = Arrays.asList(
                new Book("Potop", "1WR"),
                new Book("Chłopki", "2ASD"),
                new Book("Zbrodnia i Kara", "3DSA"),
                new Book("Lalka", "4ASF")
        );

        //System.out.println((new Book("x", "qwe").equals(new Book("x", "qwe"))));
        Library library = new Library(books);
        library.checkABook("5ASD");
        library.checkABook("3DSA");
        library.borrowABook("3DSA");
        library.checkABook("3DSA");
        library.returnABook("3DSA");

//        Brak książki o isbn 5ASD.
//        Książka Zbrodnia i Kara dostępna.
//        Książka Zbrodnia i Kara została wypożyczona.
//        Książka niedostępna.
//        Książka Zbrodnia i Kara została zwrócona.
    }
}
