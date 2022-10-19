package fr.esgi.al.tps.classe1.tp18.infrastructure;

import fr.esgi.al.tps.classe1.tp18.domain.Address;
import fr.esgi.al.tps.classe1.tp18.domain.AddressDao;

public class ConsoleAddressDAO implements AddressDao {
    @Override
    public void find(AddressDataModel address) {
        System.out.println("[ConsoleAddressDAO]- find");
    }

    @Override
    public void create(AddressDataModel address) {
        System.out.println("[ConsoleAddressDAO]- create");
    }

    @Override
    public void delete(AddressDataModel address) {
        System.out.println("[ConsoleAddressDAO]- delete");
    }

    @Override
    public void update(AddressDataModel address) {
        System.out.println("[ConsoleAddressDAO]- update");
    }
}
