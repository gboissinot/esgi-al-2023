package fr.esgi.al.kernel;

public interface EventDispatcher<E extends Event> {

    void dispatch(E event);

    void register(Class<E> eventClass, EventHandler<E> handler);
}
