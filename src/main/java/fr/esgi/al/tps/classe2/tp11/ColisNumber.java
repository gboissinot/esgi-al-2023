package fr.esgi.al.tps.classe2.tp11;

public final class ColisNumber {

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
