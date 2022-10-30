package fr.esgi.al.tps.oop.classe1.tp21.domain;

public class Address {
    private final String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
