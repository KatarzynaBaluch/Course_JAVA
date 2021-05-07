package Sekcja7_TablicePetleLancuchy;

public class Person {
    private Child[] children;

    public void setChildren1(Child[] children)
    {
        this.children=children;
    }

    public void setChildren2(Child... children) //jak inne parametry oprócz varargs to na poczatku
    {
        //bo mozna wywolac tez pustą
        if(children!=null){
            this.children=children;
        }
        else{
            this.children=new Child[0];
        }
    }

}
