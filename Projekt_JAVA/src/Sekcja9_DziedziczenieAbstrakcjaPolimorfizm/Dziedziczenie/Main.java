package Sekcja9_DziedziczenieAbstrakcjaPolimorfizm.Dziedziczenie;

public class Main {
    public static void main(String[] args) {
        SoccerFun soccerFun=new Amateur("Jan", 23);
        Person coach=new Coach("Adam", 45);

        soccerFun.whoAmI();
        ((Amateur)soccerFun).amateur();
        coach.whoAmI();

        //((Coach)soccerFun).whoAmI(); //błąd ClassCastException
        //dlatego
        if(soccerFun instanceof Coach)
        {
            ((Coach)soccerFun).whoAmI();
        }
    }


}
