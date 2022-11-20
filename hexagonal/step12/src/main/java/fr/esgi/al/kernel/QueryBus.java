package fr.esgi.al.kernel;

public interface QueryBus<Q extends Query<Q>> {
    <R> R post(Q query);

    <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler);
}
