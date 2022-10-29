package fr.esgi.al.tps.classe1.tp5;

import java.util.Map;

final class ServiceLocator2 {
    private static final Map<Class<? extends Object>, Object> _registry = Map.of(
            MyService1.class, new MyService1(),
            MyService2.class, new MyService2()
    );

    private ServiceLocator2() {
        throw new AssertionError();
    }

    public static <T> T get(Class<T> classz) {
        return (T) _registry.get(classz);
    }
}
