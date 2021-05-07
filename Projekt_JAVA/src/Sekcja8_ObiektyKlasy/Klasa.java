package Sekcja8_ObiektyKlasy;

public class Klasa {
    int var=1;
    private static int staticVar;

    //nasted - zagnieżdźony
    public class PublicNested
    {
        private int intVarNested;



        public void method(){
            System.out.println("PublicNested.intVarNested= "+intVarNested);
            System.out.println("Klasa.var (wywołana z Nested) "+var);
        }
    }

    private class PrivateNested
    {

    }

    class DefaultNested //bez modyfikatoraa, czyli jest domyślny = widoczne tylko w obrębie tego pakietu
    {

    }

    public static class PublicStsticNested
    {
        public void method()
        {
            System.out.println("Klasa.staticVar (wywołana z publicStaticNested) "+staticVar);
        }
    }

    private static class PrivateStaticNested
    {

    }

    static class DefaultStaticNested
    {

    }
}
