package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie2;

public interface Readable {
    void read();

    default void doIt()
    {
        System.out.println("Do it: read");
    }
}
