package fr.esgi.al.tps.classe1.tp18.domain;

import fr.esgi.al.tps.classe1.tp18.infrastructure.AddressDataModel;

public interface AddressDao {

    void find(AddressDataModel address);

    void create(AddressDataModel address);

    void delete(AddressDataModel address);

    void update(AddressDataModel address);
}
