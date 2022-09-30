package fr.esgi.al.tps.classe2.tp3;

final class DefaultLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[DEFAULT] "+ message);
    }
}
