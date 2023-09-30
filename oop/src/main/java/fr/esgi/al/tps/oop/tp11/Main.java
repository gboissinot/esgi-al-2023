package fr.esgi.al.tps.oop.tp11;

public class Main {

    public static void main(String[] args) {
        final Colis colis = Colis.create(ColisNumber.of(123));
        colis.deliver();
        System.out.println(colis);
    }
}
