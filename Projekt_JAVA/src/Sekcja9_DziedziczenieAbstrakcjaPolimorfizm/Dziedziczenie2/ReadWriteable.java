package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie2;

public interface ReadWriteable extends Readable, Writeable{

    void delete();

    default void doIt()
    {
        System.out.println("Do it: read&write");
    }
}
