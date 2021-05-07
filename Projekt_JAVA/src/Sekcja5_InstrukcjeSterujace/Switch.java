package Sekcja5_InstrukcjeSterujace;

public class Switch {
    public static void main(String[] args)
    {
        String switchResult;
        int variableForTesting=1;
        switch(variableForTesting)
        {
            case 1:
                switchResult ="one";
                break;
            case 2:
                switchResult="two";
                break;
            default:
                switchResult="unknown";
                break;
        }

        System.out.println(switchResult);


        switch(variableForTesting)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                switchResult="fromone to four";
                break;
            default:
                switchResult="unknown";
                break;
        }

        System.out.println(switchResult);

    }
}
