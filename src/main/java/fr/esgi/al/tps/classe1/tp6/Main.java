package fr.esgi.al.tps.classe1.tp6;

public class Main {

    public static void main(String[] args) {
        //final Logger logger = LoggerFactory.createFileLogger("/tmp/classe1.log");
        var logger = new ConsoleLogger();
        MyService myService = new MyService(logger);
        myService.myMethod();
    }
}
