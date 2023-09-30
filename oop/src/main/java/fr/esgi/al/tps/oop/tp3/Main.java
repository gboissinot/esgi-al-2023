package fr.esgi.al.tps.oop.tp3;

public class Main {
    public static void main(String[] args) {
        Logger logger = (message) -> {
            System.out.println("[INLINE LOG] " + message);
        };

        var myService = new MyService(logger);
        myService.myMethod();

        var myOtherService = new MyOtherService(logger);
        myOtherService.otherServiceMethod();
    }
}
