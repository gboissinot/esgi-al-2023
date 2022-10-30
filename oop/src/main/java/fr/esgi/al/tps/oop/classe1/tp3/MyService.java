package fr.esgi.al.tps.oop.classe1.tp3;

final class MyService {

    private final Logger logger;

    //Inject the Logger service as dependency
    public MyService(Logger logger) {
        this.logger = logger;
    }

    void myMethod() {
        // Inject the logger through the service locator
        //Logger logger = ServiceLocator.getLogger();
        logger.log("myMethod");
    }
}
