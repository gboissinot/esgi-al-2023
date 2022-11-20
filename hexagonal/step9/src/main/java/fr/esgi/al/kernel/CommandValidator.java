package fr.esgi.al.kernel;

import javax.validation.Validation;
import javax.validation.Validator;

public final class CommandValidator {

    private static CommandValidator INSTANCE = null;

    private final Validator validator;

    private CommandValidator(Validator validator) {
        this.validator = validator;
    }

    private static CommandValidator create() {
        var factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        return new CommandValidator(validator);
    }

    public static CommandValidator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = CommandValidator.create();
        }
        return INSTANCE;
    }

    public Validator validator() {
        return validator;
    }
}
