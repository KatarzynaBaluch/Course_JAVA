package Sekcja4_Zmienne_Stale_i_Operatory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Typy_prymitywne {
    public static void main(String[] args){
        String name;
        int age;
        byte byteVar=10; //8 bitów > -128-127
        short shortVar=200;
        int intVar=2000;
        long longVar=2000l; //przy longu L lub l na koncu


        int widening=(int)byteVar;
        byte narrowing=(byte)intVar;
        System.out.println(narrowing);
        System.out.println(Integer.toBinaryString(intVar));

        //notacje typy całkowite
        int intFromBin=0b1010; //przedrostek 0B lub 0b informuje, że bin
        int intFromOctal=0123; //przedrostek 0 zapis Octa
        int intFromHex=0x3A9; //przedrostek 0x lub 0X zapis
        int intWithStress=1_000_000_000; //z _ z podkreśleniem

        //operatory
        int age2=18;
        byte narrowing2=(byte)100;
        int negation=-10;
        int x;
        x=5+3;//8
        x=5-3;//2
        x=5*3;//15
        x=3/5;//0 - dzielenie całkowite
        x=7%2;//1 - modulo
        x=(3+4)*5;

        //inkrementacja
        int y=0;
        System.out.println(y++);
        System.out.println(++y);

        //dekrementacja
        y--;
        --y;

        //przypisania+arytmetyczny
        int z=0;
        z+=5;
        z-=3;
        z*=3;
        z/=9;

        //zmiennoprzecinkowe
        float floatVar=2.3f; //końcowka f, bo domyslnie double
        double doubleVar=2.54; //ew. można dać na końcu d
        double doubleNotation=1.2e2; //1.2*10^2
        System.out.println(2.0-1.1);
        BigDecimal bigDecimal=new BigDecimal(2.0);
        BigDecimal substract=bigDecimal.subtract(new BigDecimal(1.1));
        System.out.println(bigDecimal);
        System.out.println(substract.setScale(2, RoundingMode.HALF_DOWN));

        double widening2=(double) floatVar; //można pominąć (double) - jest na szaro
        float wideningFromByteToFloat=byteVar; //można pominąć (byte)
        double narrowing3=(float) doubleVar;
        float narrowingFromLongToFloat=(float)longVar;
        int narrowingFromDoubleToInt=(int)1.1;
        System.out.println(narrowingFromDoubleToInt);

        //notacje typy zmiennoprzecinkowe
        double doubleFromHex=0xAA; //z Hexa
        double doybleWithStress=1_000_00.3; //z pokreśleniem

        //chary
        char charVar='$';
        char charVar2='\u03C9';
        System.out.println(charVar);
        System.out.println(charVar2);
        System.out.println("Omega Symbol: \u03C9");

        char widening3=(char)byteVar;
        char narrowing4=(char)longVar;
        int casting='%';
        char castingFromFloat=(char) 45.1; //najpierw na całkowity, potem na char
        char charFromInt=1000; //ale maks 65535, bo jest 65536 znaków, a indeksowanie od 0

        char c='5';
        System.out.println(c>'5');

        //boolean
        boolean trueVar=true;
        boolean falseVar=false;

        //przy booleanach nie ma rzutowania - ani w jedną ani w drugą stronę














    }
}
