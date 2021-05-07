package Sekcja8_ObiektyKlasy;

public class MainPorownywanie {

    public static void main(String[] args)
    {
        int i1=100;
        int i2=100;
        Integer i3=new Integer(100);
        Integer i4=new Integer(100);

        System.out.println("i1==i2: "+(i1==i2));
        //jeśli ma prymitywny i wraper to wraper sprowadza do prymitywnego
        System.out.println("i1==i3: "+(i1==i3)); //to samo co i3.intValue()
        System.out.println("i3==i4: "+(i3==i4));

        //bo Cash do 128
        Integer i5=Integer.valueOf(127);
        Integer i6=Integer.valueOf(127);
        Integer i7=Integer.valueOf(1000);
        Integer i8=Integer.valueOf(1000);

        System.out.println("i5==i6: "+(i5==i6));
        System.out.println("i7==i8: "+(i7==i8));

        String car1=new String("ford");
        String car2=new String("ford");
        System.out.println("ca1==car2: "+(car1==car2));

        //bo StringPool
        String car3=new String("ford").intern();
        String car4=new String("ford").intern();
        System.out.println("ca3==car4: "+(car3==car4));

        String car5=new String("ford").intern();
        String car6=new String("ford").intern();
        System.out.println("car5==car6 "+(car5==car6));

    }
}
