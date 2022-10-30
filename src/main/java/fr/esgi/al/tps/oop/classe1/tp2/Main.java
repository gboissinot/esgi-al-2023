package fr.esgi.al.tps.oop.classe1.tp2;

public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.bar(() -> System.out.println("LAMBDA"));
    }
}
