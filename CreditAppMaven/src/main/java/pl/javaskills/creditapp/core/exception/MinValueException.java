package pl.javaskills.creditapp.core.exception;

public class MinValueException extends  ValidationException{

    public MinValueException(String field, int expectedMinValue) {
        super(String.format("Field %s is invalid. Min value=%s", field, expectedMinValue));
    }

    public MinValueException(String field, double expectedMinValue) {
        super(String.format("Field %s is invalid. Min value=%s", field, expectedMinValue));
    }
}
