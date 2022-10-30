package fr.esgi.al.tps.oop.classe1.tp18.domain;

import java.util.UUID;

// Application service
public final class UserService {
    private final UserDao userDao;
    private final AddressDao addressDao;

    public UserService(UserDao userDao, AddressDao addressDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    public void create(String username, String city) {

        var user = new User(UUID.randomUUID().toString(), username, new Address(city));
        userDao.create(UserDataModel.of(user));

        var address = user.getAddress();
        addressDao.create(AddressDataModel.of(user.getAddress()));
    }
}
