package fr.esgi.al.tps.classe1.tp18.infrastructure;

import fr.esgi.al.tps.classe1.tp18.domain.Address;

// DTO : a data container for the AddressDAO
public class AddressDataModel {
    public final String city;

    public AddressDataModel(String city) {
        this.city = city;
    }

    public static AddressDataModel create(Address address) {
        return new AddressDataModel(address.getCity());
    }
}
