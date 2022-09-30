package fr.esgi.al.tps.classe1.tp3;

public class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    void myMethod() {
        //Logger logger = ServiceLocator.getLogger();
        logger.log("my Method");
    }
}
