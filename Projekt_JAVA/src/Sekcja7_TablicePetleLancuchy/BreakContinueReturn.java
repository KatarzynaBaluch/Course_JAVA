package Sekcja7_TablicePetleLancuchy;

import java.util.Arrays;

public class BreakContinueReturn {
    public static void main(String[] args)
    {
        //przykład nr 1

        //1 sposób
        int[] numbers = {1, 2, 4, 6, 9, 2, 0, 4, 7};
        int sum = 0;
        boolean match = false;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==0 && !match)
            {
                sum+=numbers[i];
            }
            if(numbers[i]==0)
            {
                match=true;
            }
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Suma parzystych do zera: "+sum);

        //2 sposób
        //z breakami i continue
        sum=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]==0)
            {
                break;
            }
            if(numbers[i]%2==1)
            {
                continue;
            }
            sum+=numbers[i];
        }
        System.out.println(Arrays.toString(numbers));
        System.out.println("Suma parzystych do zera: "+sum);


        //przykład nr 2

        //sposob 1
        int[] array1={2,2,4,3};
        int[] array2={0,5,4,7};

        int match2=-1;

        int numberOfInteractions=0;
        first:
        for (int i=0;i<array1.length;i++)
        {
            second:
            for (int j=0;j<array2.length;j++)
            {
                numberOfInteractions++;
                System.out.println("Comparing: "+array1[i]+" and "+array2[j]);
                if(array1[i]==array2[j])
                {
                    match2=array1[i];
                    break first; //mozna otykietowac petle, bez etykiety break zadzialalby tylko na ta wewnetrzna
                }
            }

        }
        System.out.println("Znaleziono: "+match2+" po "+numberOfInteractions+" iteracjach");


        //sposob2

        match2=-1;

        numberOfInteractions=0;
        for (int i=0;i<array1.length;i++)
        {
            for (int j=0;j<array2.length;j++)
            {
                numberOfInteractions++;
                System.out.println("Comparing: "+array1[i]+" and "+array2[j]);
                if(array1[i]==array2[j])
                {
                    match2=array1[i];
                    return; //wyjdzie z całego maina
                }
            }

        }
        System.out.println("Znaleziono: "+match2+" po "+numberOfInteractions+" iteracjach");

    }
}
