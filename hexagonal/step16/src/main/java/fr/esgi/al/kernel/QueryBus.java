package fr.esgi.al.kernel;

public interface QueryBus<Q extends Query> {
    <R> R post(Q query);

    <R> void register(Class<Q> queryClass, QueryHandler<Q, R> queryHandler);
}
