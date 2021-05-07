package pl.javaskills.creditapp.core;

import java.time.ZoneId;
import java.util.Locale;

public interface Constants {

    //public static final
    double MORTGAGE_LOAN_RATE = 0.2;
    double PERSONAL_LOAN_LOAN_RATE = 0.1;
    double MIN_LOAN_AMOUNT_MORTGAGE = 100000.0;


    //regexy
    String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,9}";
    String LAST_NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{3,19}([-\\s][A-ZĄ-Ź][a-zą-ź]{5,19})?";
    String INTEGER_REGEX = "[0-9]+";
    String DOUBLE_REGEX = "(\\d+)(\\,\\d+)?";
    String PHONE_NUMBER_REGEX = "(\\+[0-9]{2})?[0-9]{9}";
    String EMAIL_ADDRESS_REGEX = ".+@.+";
    String PESEL_REGEX="[0-9]{11}";

    ZoneId DEFAULT_SYSTEM_ZONE_ID=ZoneId.of("America/New_York");
    Locale DEFAULT_LOCALE=Locale.US;

    String BIK_API_ENDPOINT_URL= "https://test-api.javaskills.pl/udemy/bik/scoring";

    String OUTPUT_PATH="C:\\tmp_java\\";

}
