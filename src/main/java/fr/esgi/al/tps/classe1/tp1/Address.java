package fr.esgi.al.tps.classe1.tp1;

import java.util.Objects;

public final class Address {

    private final String city;
    private final ZipCode zipCode;

    private Address(String city, ZipCode zipCode) {
        this.city = Objects.requireNonNull(city);
        this.zipCode = Objects.requireNonNull(zipCode);
    }

    public static Address of(String city, String zipCode) {
        return new Address(city, ZipCode.of(zipCode));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", zipCode=" + zipCode.toString() +
                '}';
    }
}
