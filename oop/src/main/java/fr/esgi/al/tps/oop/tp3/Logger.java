package fr.esgi.al.tps.oop.tp3;

@FunctionalInterface
public interface Logger {
    void log(String message);

//    default void log(String message) {
//        System.out.println("[DEFAULT LOG] - " + message);
//    }
}
