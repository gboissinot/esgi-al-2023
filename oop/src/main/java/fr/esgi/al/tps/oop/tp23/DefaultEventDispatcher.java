package fr.esgi.al.tps.oop.tp23;

import java.util.List;
import java.util.Map;

public class DefaultEventDispatcher implements EventDispatcher {

    private final Map<Class<? extends Event>, List<Listener>> listenersMap;

    public DefaultEventDispatcher(Map<Class<? extends Event>, List<Listener>> listenersMap) {
        this.listenersMap = listenersMap;
    }

    @Override
    public void dispatch(Event event){
        final List<Listener> listeners = listenersMap.get(event.getClass());
        for (Listener listener : listeners) {
            listener.listenTo(event);
        }
    }
}
