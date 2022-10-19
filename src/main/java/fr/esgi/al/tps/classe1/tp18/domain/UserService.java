package fr.esgi.al.tps.classe1.tp18.domain;

import fr.esgi.al.tps.classe1.tp18.infrastructure.AddressDataModel;
import fr.esgi.al.tps.classe1.tp18.infrastructure.UserDataModel;

// Application service
public class UserService {
    private final UserDao userDao;
    private final AddressDao addressDao;

    public UserService(UserDao userDao, AddressDao addressDao) {
        this.userDao = userDao;
        this.addressDao = addressDao;
    }

    public void create(User user) {

        userDao.create(UserDataModel.create(user));

        var address = user.getAddress();
        addressDao.create(AddressDataModel.create(address));

    }
}
