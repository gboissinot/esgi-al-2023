package fr.esgi.al.tps.classe2.tp11;

public class Main {

    public static void main(String[] args) {
        final Colis colis = Colis.create(ColisNumber.of(123));
        colis.markAsDelivered();
        System.out.println(colis);
    }
}
