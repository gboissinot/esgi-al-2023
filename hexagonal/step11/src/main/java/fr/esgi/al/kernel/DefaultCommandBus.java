package fr.esgi.al.kernel;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

class DefaultCommandBus<C extends Command<C>> implements CommandBus<C> {

    private final Map<Class<C>, CommandHandler> registry;
    private final Validator validator;

    DefaultCommandBus(Map<Class<C>, CommandHandler> registry, Validator validator) {
        this.registry = registry;
        this.validator = validator;
    }

    @Override
    public <R> R post(C command) {
        final Set<ConstraintViolation<C>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }

        var commandHandler = registry.get(command.getClass());
        return (R) commandHandler.handle(command);
    }

    @Override
    public <R> void register(Class<C> commandClass, CommandHandler<C, R> commandHandler) {
        registry.putIfAbsent(commandClass, commandHandler);
    }
}
