package fr.esgi.al.tps.classe1.tp6;

final class MyService {

    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    public void myMethod() {
        logger.log("Inside service");
    }
}
