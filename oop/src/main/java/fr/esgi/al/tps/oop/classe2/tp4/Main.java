package fr.esgi.al.tps.oop.classe2.tp4;

public class Main {

    public static void main(String[] args) {
        var message = "Hello ESGI";
        var logger = new FileLogger(new DefaultFormatter());
        logger.log(message);
    }
}
