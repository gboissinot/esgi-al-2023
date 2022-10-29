package fr.esgi.al.tps.classe1.tp13;

public class Main {
    public static void main(String[] args) {
        var colis = Colis.create(123);
        colis.cancel();
        colis.cancel();
        colis.cancel();
        System.out.println("History:" + colis.history());
    }
}
