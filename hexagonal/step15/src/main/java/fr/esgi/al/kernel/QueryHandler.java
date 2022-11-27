package fr.esgi.al.kernel;

public interface QueryHandler<Q extends Query<Q>, R> {
    R handle(Q query);
}
