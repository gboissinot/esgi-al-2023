package fr.esgi.al.tps.tp2;

public class Main2 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.bar(() -> System.out.println("LAMBDA"));
    }
}
