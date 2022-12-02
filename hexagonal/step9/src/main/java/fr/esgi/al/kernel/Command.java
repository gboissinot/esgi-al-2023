package fr.esgi.al.kernel;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface Command<C> {

    @SuppressWarnings("all")
    default void validate(C command) {
        var validator = CommandValidator.getInstance().validator();
        final Set<ConstraintViolation<C>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }
    }
}
