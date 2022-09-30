package fr.esgi.al.tps.classe1.tp4;

final class ConsoleLogger implements Logger {

    private final Formatter formatter;

    public ConsoleLogger(Formatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public void log(String message) {
        System.out.println(formatter.format(message));
    }
}
