package fr.esgi.al.tps.oop.classe1.tp18.domain;

public interface AddressDao {

    void find(AddressDataModel address);

    void create(AddressDataModel address);

    void delete(AddressDataModel address);

    void update(AddressDataModel address);
}
