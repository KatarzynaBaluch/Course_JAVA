package pl.javaskills.creditapp.core.validation;

import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.LoanApplication;

public class NOT_USED_PersonValidator implements Validator{

    private final PersonalDataValidator personalDataValidator;

    public NOT_USED_PersonValidator(PersonalDataValidator personalDataValidator) {
        this.personalDataValidator = personalDataValidator;
    }

    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {

        ValidationUtils.validateNotNull("personalData",personalDataValidator);
        personalDataValidator.validate(loanApplication);

        //to do
        //validate contact data
        //validate finance data
    }
}
