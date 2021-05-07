package Sekcja8_ObiektyKlasy;

import pl.javaskills.creditapp.core.model.Person;

public class MainKlasa {
    public static void main(String[] args) {

        //do zagnieźdżonej trzeba mieć instancję
        Klasa.PublicNested publicNested=new Klasa().new PublicNested();

        //do zagnieżdżonej statycznej nie potrzeba instancji
        Klasa.PublicStsticNested publicStsticNested=new Klasa.PublicStsticNested();

        //BUILDER
        //new Car_BuilderClass() - zabrionione, bo konstruktor prywatny

        Car_BuilderClass car = new Car_BuilderClass.Builder()
                .withBrand("ford")
                .withYearOfManufacture(1998)
                .build();

        new Person_KonstruktoryBlokiInicjalizacyjne("Kasia", 23);

        new PrzekazywanieZmiennych().passingVariablesToMethod();
    }
}
