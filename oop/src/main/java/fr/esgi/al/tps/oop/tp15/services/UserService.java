package fr.esgi.al.tps.oop.tp15.services;

import fr.esgi.al.tps.oop.tp15.domain.UserDao;
import fr.esgi.al.tps.oop.tp15.domain.model.User;

public final class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(String lastname, String firstname) {
        var user = new User(lastname, firstname);
        userDao.create(user);
    }
}
