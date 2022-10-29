package fr.esgi.al.tps.classe1.tp17.domain;

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

        User user = new User(UUID.randomUUID().toString(), username, new Address(city));
        System.out.println("[UserService] - create - user - " + user);
        userDao.create(user);

        var address = user.getAddress();
        System.out.println("[UserService] - create - address - " + address);
        addressDao.create(address);
    }
}
