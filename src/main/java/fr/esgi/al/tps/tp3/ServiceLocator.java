package fr.esgi.al.tps.tp3;

import java.util.Map;

@Deprecated
public class ServiceLocator {

    private static final Map<String, Object> _registry = Map.of(
            "LOG1", new DefaultLogger(),
            "LOG2", new MySecondLogger()
    );

    public static Logger getLogger() {
        return (Logger) _registry.get("LOG2");
    }
}
