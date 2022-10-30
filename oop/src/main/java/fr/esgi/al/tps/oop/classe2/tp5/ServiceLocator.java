package fr.esgi.al.tps.oop.classe2.tp5;

import fr.esgi.al.tps.oop.classe2.tp3.Logger;

import java.util.Map;

public final class ServiceLocator {

    private static final Map<String, Object> _registry = Map.of(
            "logger", new FileLogger()
    );

    private ServiceLocator() {
        throw new AssertionError();
    }

    public static <T> T get(String identifier) {
        T myService = (T) _registry.get(identifier);
        if (myService == null) {
            throw new IllegalArgumentException(String.format("Unknown %s service", identifier));
        }
        return myService;
    }

    public static Logger getLogger() {
        return (Logger) _registry.get("logger");
    }
}
