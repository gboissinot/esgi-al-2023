package fr.esgi.al.tps.oop.tp4;

final class DefaultFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "[LOG] - " + message;
    }
}
