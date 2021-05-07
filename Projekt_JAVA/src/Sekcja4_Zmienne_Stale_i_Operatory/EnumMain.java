package Sekcja4_Zmienne_Stale_i_Operatory;

public class EnumMain {
    public static void main(String[] args)
    {
        double area=Constants.PI_VALUE*2*2;
        Professions professions=Professions.TEACHER;
        boolean professionBoolean=Professions.BUILDER.isPhysicalWorker();
        System.out.println("indeks BUILDER: "+Professions.BUILDER.ordinal());

        System.out.println("name (TEACHER): "+Professions.TEACHER.name());

        Professions p=Professions.valueOf("TEACHER");
    }
}
