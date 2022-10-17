package fr.esgi.al.tps.classe1.tp6;

final class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
