package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class MainPrzeciazanie {
    public static void main(String[] args) {

        //>double > float > int > char
        //                  int > short > byte

        int i = 1;
        process(i);
    }

    public static void process(int... var) {
        System.out.println("int...");
    }

    public static void process(Integer var) {
        System.out.println("Integer");
    }
}
