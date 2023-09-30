package fr.esgi.al.tps.oop.tp12;

public class Main {

    public static void main(String[] args) {
        Colis colis = Colis.create(ColisNumber.of(123));
        colis.deliver();
        final History history = colis.history();
        System.out.println(history);
    }
}
