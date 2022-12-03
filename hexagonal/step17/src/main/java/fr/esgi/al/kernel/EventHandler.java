package fr.esgi.al.kernel;

public interface EventHandler<E extends Event> {
    void handle(E event);
}
