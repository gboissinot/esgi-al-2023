package fr.esgi.al.tps.oop.classe1.tp3;

final class MyCustomLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[MY CUSTOM LOG]- " + message);
    }
}
