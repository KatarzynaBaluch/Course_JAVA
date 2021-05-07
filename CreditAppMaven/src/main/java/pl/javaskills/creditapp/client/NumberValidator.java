package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;

public class NumberValidator {

    public static boolean validaterInteger(String integerValue, int min, int max)
    {
        if(integerValue.matches(Constants.INTEGER_REGEX))
        {
            int value=Integer.parseInt(integerValue);
            if(value>=min&&value<=max)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validateDouble(String doubleValue, double min, double max)
    {
        if(doubleValue.matches(Constants.DOUBLE_REGEX))
        {
            double value=Double.parseDouble(doubleValue);
            if(value>=min&&value<=max)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean validateInteger(String integerValue, int... allowedValues)
    {
        if(integerValue.matches(Constants.INTEGER_REGEX))
        {
            int value=Integer.parseInt(integerValue);
            for (int element:allowedValues)
            {
                if(element==value)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
