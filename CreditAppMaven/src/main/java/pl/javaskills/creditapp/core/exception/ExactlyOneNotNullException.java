package pl.javaskills.creditapp.core.exception;

import java.lang.reflect.Field;
import java.util.Set;

public class ExactlyOneNotNullException extends ValidationException{
    public ExactlyOneNotNullException(Set<String> fieldNames) {
        super(String.format("Excactly one of the fields must be not null %s", fieldNames));
    }
}
