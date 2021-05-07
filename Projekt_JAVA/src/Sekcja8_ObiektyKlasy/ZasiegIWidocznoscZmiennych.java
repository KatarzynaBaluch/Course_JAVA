package Sekcja8_ObiektyKlasy;

public class ZasiegIWidocznoscZmiennych {
    private String president="Duda";
    private String city="Warszawa";

    public void katowice() {
        String president = "Krupa";

        //shadowing - przysłanianie
        System.out.println("president from void: " + president);
        System.out.println("president from instance of ZasiegIWidocznoscZmiennych: " + this.president);

        //klasa zagnieżdżona w metodzie
        class MusicClub {
            private String president = "Kowalski";

            public void liverpool() {
                String president = "Nowak";

                System.out.println("president from loverpool: " + president);
                System.out.println("president from instance of MusicClub: " + this.president);

                //nie mozna wyswietlic president z ZasiegIWidocznoscZmiennych, ale nieprzysłonięte można
                System.out.println("City from instance of ZasiegIWidocznoscZmiennych: " + city);

                System.out.println("president from instance of ZasiegIWidocznoscZmiennych: " + ZasiegIWidocznoscZmiennych.this.president);

            }
        }
    }
        public void scope(String name3)
        {
            String name="Kasia";
            int x=0;
            if(x>0)
            {
               // String name="Ala"; - nie można, bo on widzi name z metody
                String name2="Beata"; //widoczna tylko w if(){ ... }
            }

            if(x>0)
            {
                String name2="Darek"; //widoczna tylko w if(){ ... }
            }
        }

}
