package fr.esgi.al.tps.classe1.tp3;

public class DefaultLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[LOG] - " + message);
    }
}
