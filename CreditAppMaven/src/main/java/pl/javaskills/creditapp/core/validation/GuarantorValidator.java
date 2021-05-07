package pl.javaskills.creditapp.core.validation;

import com.sun.source.doctree.SeeTree;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.exception.ValidationException;
import pl.javaskills.creditapp.core.model.Guarantor;
import pl.javaskills.creditapp.core.model.LoanApplication;

import java.util.Set;

public class GuarantorValidator implements Validator {


    @Override
    public void validate(LoanApplication loanApplication) throws ValidationException {
        final Set<Guarantor> guarantors=loanApplication.getGuarantors();

        for (Guarantor g:guarantors)
        {
            ValidationUtils.validateNotNull("GuarantorAge", g.getAge());
            ValidationUtils.validateMinValue("GuarantorAge", 0,g.getAge());
            ValidationUtils.validateRegex("GuarantorPesel", g.getPesel(),Constants.PESEL_REGEX);
        }

    }
}
