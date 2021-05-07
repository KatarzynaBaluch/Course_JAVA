package Sekcja8_ObiektyKlasy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StosSterta {
    public static void main(String[] args) {

        final PersonDoStosSterta person =new PersonDoStosSterta("Kasia", 23);

        person.method();

        person.method();
        method();

    }
    public static void method()
    {
        List<String > lista=new ArrayList<String>();
        while (true)
        {
            lista.add(UUID.randomUUID().toString());
        }
    }
}
