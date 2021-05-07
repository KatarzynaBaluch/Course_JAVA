package Sekcja7_TablicePetleLancuchy;

public class PetleFor {
    public static void main(String args[])
    {
        for (int i=0;i<=5;i++)
        {
            System.out.println(i);
        }
/* //to jest poprawne!
        int j=0;
        for( ;j<=5;j++)
        {
            System.out.println(j);
        }

        int k=0;
        for( ;;k++)
        {
            System.out.println(k);
        }

       int l=0;
       for (;;)
       {
           System.out.println(l);
       }

 */

        int[] array={3,4,5,6};
        for (int i=0;i<array.length;i++)
        {
            System.out.println(array[i]);
        }

        for (int element:array)
        {
           System.out.println(element);
        }
    }
}
