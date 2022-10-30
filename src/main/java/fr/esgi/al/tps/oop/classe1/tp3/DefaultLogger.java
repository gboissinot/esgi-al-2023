package fr.esgi.al.tps.oop.classe1.tp3;

final class DefaultLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[LOG] - " + message);
    }
}
