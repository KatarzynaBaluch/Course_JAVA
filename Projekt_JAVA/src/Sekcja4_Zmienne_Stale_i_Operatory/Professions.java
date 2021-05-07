package Sekcja4_Zmienne_Stale_i_Operatory;

public enum Professions {
    TEACHER(false),
    BUILDER(true);

    private boolean isPhysicalWorker;

    Professions(boolean isPhysicalWorker){
        this.isPhysicalWorker=isPhysicalWorker;
    }
    public boolean isPhysicalWorker(){
        return this.isPhysicalWorker;
    }
}
