package fr.esgi.al.tps.classe2.tp10;

import java.util.Objects;

public class Year {

    private final int value;

    public Year(int value) {
        this.value = value;
    }

    public Year next(){
        return new Year(value+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year = (Year) o;
        return value == year.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
