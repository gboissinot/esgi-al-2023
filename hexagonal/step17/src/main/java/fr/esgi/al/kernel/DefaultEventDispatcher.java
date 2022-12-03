package fr.esgi.al.kernel;

import java.util.HashMap;
import java.util.Map;

public class DefaultEventDispatcher<E extends Event> implements EventDispatcher<E> {

    private final Map<Class<E>, EventHandler<E>> register;

    private DefaultEventDispatcher(Map<Class<E>, EventHandler<E>> register) {
        this.register = register;
    }

    public static DefaultEventDispatcher create() {
        return new DefaultEventDispatcher<>(new HashMap<>());
    }

    @Override
    public void dispatch(E event) {
        var eventHandler = register.get(event.getClass());
        if (eventHandler == null) {
            throw new ApplicationException(String.format("No handler for the event %s", event.name()));
        }
        eventHandler.handle(event);
    }

    @Override
    public void register(Class<E> eventClass, EventHandler<E> handler) {
        register.put(eventClass, handler);
    }
}
