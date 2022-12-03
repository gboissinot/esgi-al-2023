package fr.esgi.al.kernel;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

final class DefaultQueryBus<Q extends Query> implements QueryBus<Q> {

    private final Map<Class<Q>, QueryHandler> registry;
    private final Validator validator;

    DefaultQueryBus(Map<Class<Q>, QueryHandler> registry, Validator validator) {
        this.registry = registry;
        this.validator = validator;
    }

    @Override
    public <R> R post(Q query) {
        final Set<ConstraintViolation<Q>> violations = validator.validate(query);
        if (!violations.isEmpty()) {
            throw new RuntimeException(violations.toString());
        }

        try {
            var queryHandler = registry.get(query.getClass());
            return (R) queryHandler.handle(query);
        } catch (Exception e) {
            throw new ApplicationException(String.format("Can't execute %s", query.name()), e);
        }
    }

    @Override
    public <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler) {
        registry.putIfAbsent(queryClass, queryHandler);
    }
}
