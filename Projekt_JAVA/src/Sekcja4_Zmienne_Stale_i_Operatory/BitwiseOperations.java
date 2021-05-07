package Sekcja4_Zmienne_Stale_i_Operatory;

public class BitwiseOperations {
    public static void main(String[] args)
    {
        int a=4;
        int b=-3;

        System.out.println("a: "+String.format("%32s", Integer.toBinaryString(a)).replace(" ","0"));
        System.out.println("b: "+String.format("%32s", Integer.toBinaryString(b)).replace(" ","0"));

        int bitWiseAND=a&b;
        //00000000000000000000000000000100
        //11111111111111111111111111111101
        //________________________________
        //00000000000000000000000000000100
        System.out.println("            "+0b00000000000000000000000000000100);
        System.out.println("bitwiseAND: "+bitWiseAND);

        int bitWiseOR=a|b;
        //00000000000000000000000000000100
        //11111111111111111111111111111101
        //________________________________
        //11111111111111111111111111111101
        System.out.println("           "+0b11111111111111111111111111111101);
        System.out.println("bitwiseOR: "+bitWiseOR);

        int bitWiseXOR=a^b;
        //00000000000000000000000000000100
        //11111111111111111111111111111101
        //________________________________
        //11111111111111111111111111111001
        System.out.println("            "+0b11111111111111111111111111111001);
        System.out.println("bitWiseXOR: "+bitWiseXOR);

        int bitWiseNegation=~a;
        //00000000000000000000000000000100
        //________________________________
        //11111111111111111111111111111011
        System.out.println("                 "+0b11111111111111111111111111111011);
        System.out.println("bitWiseNegation: "+bitWiseNegation);

        int bitWiseSignedShiftRightA=a>>2;
        //00000000000000000000000000000100
        //________________________________
        //--00000000000000000000000000000100
        //00000000000000000000000000000001 // zamisast -- dla dodatnich dodajemy 0
        System.out.println("                          "+0b00000000000000000000000000000001);
        System.out.println("bitWiseSignedShiftRightA: "+bitWiseSignedShiftRightA);

        int bitWiseSignedShiftRightB=b>>2;
        //11111111111111111111111111111101
        //________________________________
        //--11111111111111111111111111111101
        //11111111111111111111111111111111   // zamisast -- dla ujemnych dodajemy 1
        System.out.println("                          "+0b11111111111111111111111111111111);
        System.out.println("bitWiseSignedShiftRightB: "+bitWiseSignedShiftRightB);

        int bitWiseUnsignedShiftRightA=a>>>2;
        //00000000000000000000000000000100
        //________________________________
        //--00000000000000000000000000000100
        //00000000000000000000000000000001 // zamisast -- dla dodatnich dodajemy 0
        System.out.println("                            "+0b00000000000000000000000000000001);
        System.out.println("bitWiseUnsignedShiftRightA: "+bitWiseUnsignedShiftRightA);

        int bitWiseUnsignedShiftRightB=b>>>2;
        //11111111111111111111111111111101
        //________________________________
        //--11111111111111111111111111111101
        //00111111111111111111111111111111   // dla wszystkich dodajemy 0 z przodu
        System.out.println("                            "+0b00111111111111111111111111111111);
        System.out.println("bitWiseUnsignedShiftRightB: "+bitWiseUnsignedShiftRightB);

        int bitWiseShiftLeft=b<<2;
        //11111111111111111111111111111101
        //________________________________
      //11111111111111111111111111111101--
      //  11111111111111111111111111110100  // zamisast -- zawsze 0
        System.out.println("                  "+0b11111111111111111111111111110100);
        System.out.println("bitWiseShiftLeft: "+bitWiseShiftLeft);



    }
}
