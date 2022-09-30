package fr.esgi.al.tps.tp4;

class DefaultFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "[LOG] - " + message;
    }
}
