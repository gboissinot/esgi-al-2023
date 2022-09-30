package fr.esgi.al.tps.classe2.tp5;

public final class ServiceLocatorSingleton {

    private static final ServiceLocatorSingleton INSTANCE = new ServiceLocatorSingleton();

    private ServiceLocatorSingleton() {
    }

    public static ServiceLocatorSingleton getInstance() {
        return INSTANCE;
    }
}
