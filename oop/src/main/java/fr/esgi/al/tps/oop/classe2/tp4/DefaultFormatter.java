package fr.esgi.al.tps.oop.classe2.tp4;

class DefaultFormatter implements Formatter {
    @Override
    public String format(String message) {
        return "[LOG] - " + message;
    }
}
