package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.*;

public class ValidationUtils {

    public static void validateNotNull(String field, Object object) throws ValidationException
    {
        if (object==null)
        {
            throw new NotNullException(field);
        }
    }

    public static void validateRegex(String field, String value, String regex) throws ValidationException
    {
        if(!value.matches(regex))
        {
            throw new RegexException(field);
        }
    }

    public static void validateMinValue(String field, int expectedMinValue, int actualMinValue) throws ValidationException
    {
        if(actualMinValue<expectedMinValue)
        {
            throw new MinValueException(field, actualMinValue);
        }
    }

    public static void validateMinValue(String field, double expectedMinValue, double actualMinValue) throws ValidationException
    {
        if(actualMinValue<expectedMinValue)
        {
            throw new MinValueException(field, actualMinValue);
        }
    }

    public static void validateMaxValue(String field, int expectedMaxValue, int actualMaxValue) throws ValidationException
    {
        if(actualMaxValue>expectedMaxValue)
        {
            throw new MaxValueException(field, actualMaxValue);
        }
    }

    public static void validateMaxValue(String field, double expectedMaxValue, double actualMaxValue) throws ValidationException
    {
        if(actualMaxValue>expectedMaxValue)
        {
            throw new MaxValueException(field, actualMaxValue);
        }
    }

}
