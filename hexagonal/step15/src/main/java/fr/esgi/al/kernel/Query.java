package fr.esgi.al.kernel;

public interface Query<Q> {
    default String name() {
        return this.getClass().getSimpleName();
    }
}
