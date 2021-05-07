package Sekcja4_Zmienne_Stale_i_Operatory;

import java.util.List;

public class WrapperyAutboxingUnboxing {
    public static void main(String[] args)
    {
        Boolean isMaried=null; //do wrapera da się przypisać null
        //boolean isMarried=null; //do typu prymitywnego nie da się nulla

        List<Integer> list; //do kolekcji Wrappery
        //List<int> list;

        String input="45";
        int parseInput = Integer.parseInt(input);

        Integer integer1=new Integer(124); //konstructor @deprecated
        Integer integer2=Integer.valueOf(124);

        System.out.println(integer1==integer2); //false

        Integer n1=Integer.valueOf(127);
        Integer n2=Integer.valueOf(127);
        Integer n3=new Integer(125);
        Integer n4=new Integer(125);
        Integer n5=Integer.valueOf(128);
        Integer n6=Integer.valueOf(128);

        System.out.println(n1==n2); //true
        System.out.println(n3==n4); //false
        System.out.println(n5==n6); //false

        //WYJASNIENIE
        //int: -128 - 127
        //metoda valueOf jest z casha (nie tworzymy nowej instancji)
        //dla 127 jest z casha - porównywanie tych samych obiektów!
        //dla 128 już jest nowa instancja - porównywanie innych obiektów
        //n3, n4, n5, n6 - nowe obiekty - nie są równe

        Integer autoboxing=127; //autoboxing - java sama sobie dopisze valueOf(127)

        Integer unboxing=Integer.valueOf(128); //unboxing

    }
}
