package pl.javaskills.creditapp.core.exception;

public class RegexException extends  ValidationException{
    public RegexException(String field) {
        super(String.format("Field %s dosn't match regex", field));
    }
}
