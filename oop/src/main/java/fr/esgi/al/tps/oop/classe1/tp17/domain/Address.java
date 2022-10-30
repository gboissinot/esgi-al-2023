package fr.esgi.al.tps.oop.classe1.tp17.domain;

//Entity
public final class Address {
    private final String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
