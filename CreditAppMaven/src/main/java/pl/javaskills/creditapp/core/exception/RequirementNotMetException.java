package pl.javaskills.creditapp.core.exception;


public class RequirementNotMetException extends Exception {
    private final RequirementNotMetCause requirementNotMetCause;

    public RequirementNotMetException(RequirementNotMetCause cause) {
        this.requirementNotMetCause = cause;
    }

    public RequirementNotMetCause getRequirementNotMetException() {
        return requirementNotMetCause;
    }
}
