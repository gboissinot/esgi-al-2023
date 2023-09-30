package fr.esgi.al.tps.oop.tp3;

final class MySecondLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[LOG2] - " + message);
    }
}
