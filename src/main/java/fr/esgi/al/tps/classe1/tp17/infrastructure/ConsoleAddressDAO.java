package fr.esgi.al.tps.classe1.tp17.infrastructure;

import fr.esgi.al.tps.classe1.tp17.domain.Address;
import fr.esgi.al.tps.classe1.tp17.domain.AddressDao;

public class ConsoleAddressDAO implements AddressDao {
    @Override
    public void find(Address address) {
        System.out.println("[ConsoleAddressDAO]- find");
    }

    @Override
    public void create(Address address) {
        System.out.println("[ConsoleAddressDAO]- create");
    }

    @Override
    public void delete(Address address) {
        System.out.println("[ConsoleAddressDAO]- delete");
    }

    @Override
    public void update(Address address) {
        System.out.println("[ConsoleAddressDAO]- update");
    }
}
