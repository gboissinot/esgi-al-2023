package fr.esgi.al.tps.oop.classe1.tp13;

import java.util.Objects;

//VO ID
final class ColisId {

    private final String value;

    public ColisId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColisId colisId = (ColisId) o;
        return Objects.equals(value, colisId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ColisId{" +
                "value='" + value + '\'' +
                '}';
    }
}
