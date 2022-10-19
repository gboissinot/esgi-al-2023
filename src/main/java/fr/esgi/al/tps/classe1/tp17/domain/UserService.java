package fr.esgi.al.tps.classe1.tp17.domain;

// Application service
public class UserService {
    private final UserDao userDao;
    private final AddressDao addressDao;

    public UserService(UserDao userDao, AddressDao addressDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    public void create(User user) {

        userDao.create(user);

        var address = user.getAddress();
        addressDao.create(address);

    }
}
