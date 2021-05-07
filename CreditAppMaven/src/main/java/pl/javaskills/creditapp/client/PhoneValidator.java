package pl.javaskills.creditapp.client;

import pl.javaskills.creditapp.core.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    public static boolean validatePhoneNumber(String phoneNumber)
    {
        return phoneNumber.matches(Constants.PHONE_NUMBER_REGEX);
    }
}
