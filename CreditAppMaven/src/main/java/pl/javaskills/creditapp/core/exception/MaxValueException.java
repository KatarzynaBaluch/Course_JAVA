package pl.javaskills.creditapp.core.exception;

public class MaxValueException extends  ValidationException{

    public MaxValueException(String field, int expectedMaxValue) {
        super(String.format("Field %s is invalid. Max value=%s", field, expectedMaxValue));
    }

    public MaxValueException(String field, double expectedMaxValue) {
        super(String.format("Field %s is invalid. Max value=%s", field, expectedMaxValue));
    }
}
