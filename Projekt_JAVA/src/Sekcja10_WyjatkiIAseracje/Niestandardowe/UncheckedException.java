package Sekcja10_WyjatkiIAseracje.Niestandardowe;

public class UncheckedException extends RuntimeException {

    public UncheckedException(int var)
    {
        super("Variable is invalid (value: "+var+")");
    }
}
