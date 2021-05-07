package Sekcja4_Zmienne_Stale_i_Operatory;

public class Operatory {
    public static void main(String[] args)
    {
        int x=0;
        x=(2+5)+(int)2.0;

        boolean lessThan=x<0;
        boolean lessEqualThan=x<=0;

        boolean graterThan=x>0;
        boolean greaterEqualThan=x>=0;

        boolean noEqual=x!=0;
        boolean equal= x==0;

        boolean conjunction=true&&true;

        boolean alternative=false&&true;

        //prawa De Morgana
        //!(a ^ b) <=> (!a v !b)    //1 prawo - zaprzeczenie koniunkcji
        //!(a ^ b) <=> (!a v !b)    //2 prawo - zaprzeczenie alternatywy

        //condotion ? value for true : value for false
        boolean condition=x>0?true:false;
        String conditionString=x>0?"x większe od 0":"x mniejsze lub równe 0";
        x=-2;
        String conditionString2=x<0?"x mniejsze od 0":x<10?"x między <0;10)":"x większe lub rowne 10";
        System.out.println(conditionString2);

        //zmienna var od Java 10
        var noType=x>10?"String":1;






    }
}
