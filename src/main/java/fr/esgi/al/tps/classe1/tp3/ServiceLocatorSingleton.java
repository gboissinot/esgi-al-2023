package fr.esgi.al.tps.classe1.tp3;

//Service Locator singleton mode
final class ServiceLocatorSingleton {

    private static final ServiceLocatorSingleton INSTANCE = new ServiceLocatorSingleton();

    private ServiceLocatorSingleton() {
    }

    public static ServiceLocatorSingleton getInstance() {
        return INSTANCE;
    }
}
