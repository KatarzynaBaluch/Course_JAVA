package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie2;


public class Main {
    public static void main(String[] args) {
        DatabaseObject dbObj=new DatabaseObject();
        dbObj.doIt();

        //doIt - Java wybierze bardziej konkretną czyli tą z ReadWriteable
        //w przypadku gdyby doIt miała zarówno Readable jak i Writeable należaloby ją nadpisać w pierwszej klasie w której są uzywane i nie jest ona abstract
    }
}
