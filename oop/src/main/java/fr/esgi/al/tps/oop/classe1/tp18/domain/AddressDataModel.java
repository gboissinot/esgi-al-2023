package fr.esgi.al.tps.oop.classe1.tp18.domain;

// DTO : a data container for the AddressDAO
public final class AddressDataModel {
    public final String city;

    private AddressDataModel(String city) {
        this.city = city;
    }

    public static AddressDataModel of(Address address) {
        return new AddressDataModel(address.getCity());
    }
}
