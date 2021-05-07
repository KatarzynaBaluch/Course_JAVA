package Sekcja11_KolekcjeIMapy.LinkedHashSet;

public class LinkedHashSetZadanie {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz implementację managera webinara z ograniczoną liczbą miejsc.
         * Decyduje kolejność zgłoszeń. Dwie osoby (adresy email) nie mogą zapisać się na ten sam webinar.
         * Na koniec wydrukuj na ekran 5 pierwszych osób, które zapisały się na webinar.
         */
        WebinarManager manager = new WebinarManager();
        manager.signUp("john@");
        manager.signUp("jane@");
        manager.signUp("cindy@");
        manager.signUp("steve@");
        manager.resign("jane@");
        manager.signUp("chris@");
        manager.signUp("paul@");
        manager.signUp("james@");

        manager.printFirstFive();

//        john@ zapisany.
//        jane@ zapisany.
//        cindy@ zapisany.
//        steve@ zapisany.
//        jane@ wypisany.
//        chris@ zapisany.
//        paul@ zapisany.
//        james@ zapisany.
//        Top 5: [john@,cindy@,steve@,chris@,paul@]

    }

}
