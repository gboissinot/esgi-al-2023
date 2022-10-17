package fr.esgi.al.tps.classe1.tp3;

import java.util.Map;

public final class ServiceLocator {

    private static final Map<String, Object> _registry = Map.of(
            "logger", new MyCustomLogger()
    );

    private ServiceLocator() {
        throw new AssertionError();
    }

    public static Logger getLogger() {
        return (Logger) _registry.get("logger");
    }
}
