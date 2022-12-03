package fr.esgi.al.kernel;

public interface Event {
    default String name() {
        return getClass().getSimpleName();
    }
}
