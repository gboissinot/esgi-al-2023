package fr.esgi.al.kernel;

import javax.validation.Validation;
import javax.validation.Validator;

public final class UseCaseValidator {

    private static UseCaseValidator INSTANCE = null;

    private final Validator validator;

    private UseCaseValidator(Validator validator) {
        this.validator = validator;
    }

    private static UseCaseValidator create() {
        var factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        return new UseCaseValidator(validator);
    }

    public static UseCaseValidator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = UseCaseValidator.create();
        }
        return INSTANCE;
    }

    public Validator validator() {
        return validator;
    }
}
