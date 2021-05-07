package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;

public class StringValidator {

    public static boolean validateString(String stringValue, String regex)
    {
        return stringValue.matches(regex);
    }

    public static boolean validateEmailAddress(String emailAddress)
    {
        return emailAddress.matches(Constants.EMAIL_ADDRESS_REGEX);
    }


}
