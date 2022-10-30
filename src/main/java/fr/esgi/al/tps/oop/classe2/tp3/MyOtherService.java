package fr.esgi.al.tps.oop.classe2.tp3;

public final class MyOtherService {

    private final Logger logger;

    public MyOtherService(Logger logger) {
        this.logger = logger;
    }

    public void otherServiceMethod() {
        logger.log("Other service method");
    }
}
