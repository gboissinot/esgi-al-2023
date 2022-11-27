package fr.esgi.al.kernel;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

final class DefaultQueryBus<Q extends Query<Q>> implements QueryBus<Q> {

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
            throw new ApplicationException(violations.toString());
        }

        var queryHandler = registry.get(query.getClass());
        try {
            return (R) queryHandler.handle(query);
        } catch (Exception e) {
            throw new ApplicationException("Can't handle the query " + query.name(), e);
        }
    }

    @Override
    public <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler) {
        registry.putIfAbsent(queryClass, queryHandler);
    }
}
