package fr.esgi.al.tps.classe1.tp12;

public class Main {
    public static void main(String[] args) {
        Colis colis = Colis.create(123);
        colis.cancel();
        colis.cancel();
        colis.cancel();
        System.out.println(colis);
    }
}
