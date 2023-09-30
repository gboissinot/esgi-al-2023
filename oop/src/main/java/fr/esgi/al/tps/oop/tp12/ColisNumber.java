package fr.esgi.al.tps.oop.tp12;

//VO ID
final class ColisNumber {

    private final String value;

    private ColisNumber(String value) {
        this.value = value;
    }

    public static ColisNumber of(long value) {
        return new ColisNumber("#COLIS" + value);
    }

    @Override
    public String toString() {
        return "ColisNumber{" +
                "value='" + value + '\'' +
                '}';
    }
}
