package Sekcja10_WyjatkiIAseracje.Try_catch_finally;

public class Main {
    public static void main(String[] args) {
        try{
            throw new UncheckedLevel2a();
        }
        catch (UncheckedLevel2a | UncheckedLevel2b e) //nie można listować razem bardziej konkretne i mniej konkretne z tego samego drzewa dziedziczenia
                //typ tej zmiennej e bd pierwszy wspolny typ po ktorym dziedziczą
        {

            //ale można zrobić coś takiego
            //ale wtedy nie powinno się używac multicatcha, tylko osobno
            if(e instanceof UncheckedLevel2a)
            {
                System.out.println(((UncheckedLevel2a) e).name);
            }

        }
        finally //po wszystkich catchach
        {
            System.out.println("The end...");
        }
    }
}
