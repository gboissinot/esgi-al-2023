package fr.esgi.al.tps.oop.classe2.tp11;

//VO ID
final class ColisNumber {

    private final String value;

    public ColisNumber(String value) {
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
