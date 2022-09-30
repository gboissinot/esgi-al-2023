package fr.esgi.al.tps.classe1.tp3;

public class MyCustomLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[MY CUSTOM LOG]- " + message);
    }
}
