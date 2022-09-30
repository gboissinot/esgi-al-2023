package fr.esgi.al.tps.classe1.tp4;

public class MyService {
    private final Logger logger;

    public MyService(Logger logger) {
        this.logger = logger;
    }

    public void myMethod() {
        logger.log("Inside method");
    }
}
