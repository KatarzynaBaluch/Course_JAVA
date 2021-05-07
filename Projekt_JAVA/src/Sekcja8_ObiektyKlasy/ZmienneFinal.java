package Sekcja8_ObiektyKlasy;

//UWAGA! częśc zakomentowana, bo by się nie kompilowało

public class ZmienneFinal {
    //inicjalizacja razem z deklaracją
    private final String name="";

    //LUB

    //inicjalizacja w bloky inicjalizacyjnym
    {
        //name="";
    }

    //LUB

    //inicjalizacja w konstruktorze
    public ZmienneFinal()
    {
        //name="";
    }

    //---------------------------------------------

    //static+final > STALA - wielkimi literami
    //inicjalizacja w zmiennej z deklaracją
    private final static String NAME="";

    //inicjalizacja w statycznym bloku inicjalizacyjnym
    static {
        //NAME="";
    }

    //---------------------------------------------

    //zmienna lokalna final
    public void method()
    {
        final String name;
        //może być zadeklarowana potem
        name="";
    }

    //---------------------------------------------

    //ale finala raczej się nie pisze i  po prostu pilnuje, żeby nie zmienić jej wartości
    public void method2(final String s) //pass-by-value
    {
        //s="xyz"; //BLĄD - nie kompiluje się, bo nie można zmienić final
    }
}
