package Sekcja7_TablicePetleLancuchy;

public class InicjalizacjaTablic {
    public static void main(String[] args)
    {
        int[] array1=new int[5];
        int array2[]=new int[5]; //ale [] po nazwie rzadko stosowane

        int[] array3={1,2,3};

        int[][] twoDimArray=new int[3][4];

        int[][] twoDimArray2={{},new int[6]}; //kazdy kolejny wyumiar ma inny rozmiar

        Person person=new Person();
        Child[] children={new Child()};
        person.setChildren1(children);

        person.setChildren2(new Child(), new Child(), new Child());

    }
}
