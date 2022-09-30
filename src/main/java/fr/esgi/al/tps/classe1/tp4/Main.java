package fr.esgi.al.tps.classe1.tp4;

public class Main {
    public static void main(String[] args) {
        MyService myService =
                new MyService(
                        new ConsoleLogger(message -> "[custom inline format] - " + message));
        myService.myMethod();
    }
}
