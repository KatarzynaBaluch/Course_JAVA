package Sekcja11_KolekcjeIMapy.HashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Library {

    private final Set<Book> avaliable = new HashSet<>();
    private final Set<Book> borrowed = new HashSet<>();

    public Library(List<Book> books) {
        avaliable.addAll(books);
    }

    public void borrowABook(String isbn) {
        Optional<Book> bookOpt = findBook(avaliable, isbn);
        if (bookOpt.isPresent()) {
            borrowed.add(bookOpt.get());
            avaliable.remove(bookOpt.get());
            System.out.println("Książka " + bookOpt.get().getTitle() + " została wypożyczona");
        }

    }

    public void checkABook(String isbn) {
        Optional<Book> bookOpt = findBook(avaliable, isbn);
        Optional<Book> borrowedOpt = findBook(borrowed, isbn);

        if (bookOpt.isEmpty()) {
            if (borrowedOpt.isEmpty()) {
                System.out.println("Brak ksiazki o ISBN: " + isbn);
            } else {
                System.out.println("Książka " + borrowedOpt.get().getTitle() + " niedostepna");
            }
        } else {
            System.out.println("Książka " + bookOpt.get().getTitle() + " dostepna");
        }

    }

    public void returnABook(String isbn) {
        Optional<Book> bookOpt = findBook(borrowed, isbn);
        if (bookOpt.isPresent()) {
            borrowed.remove(bookOpt.get());
            avaliable.add(bookOpt.get());
            System.out.println("Książka " + bookOpt.get().getTitle() + " zostala zwrocona");
        }
    }

    private Optional<Book> findBook(Set<Book> set, String isbn) {
        for (Book book : set) {
            if (book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }
}
