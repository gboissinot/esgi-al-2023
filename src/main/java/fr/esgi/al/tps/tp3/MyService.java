package fr.esgi.al.tps.tp3;

public final class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    public void myMethod() {
        //var logger = ServiceLocator.getLogger();
        logger.log("Processing in myMethod");
        doProcess();
    }

    private void doProcess() {
    }
}
