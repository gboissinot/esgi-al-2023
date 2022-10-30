package fr.esgi.al.tps.oop.classe2.tp15.services;

import fr.esgi.al.tps.oop.classe2.tp15.domain.UserDao;
import fr.esgi.al.tps.oop.classe2.tp15.domain.model.User;

public final class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void create(User user) {
        userDao.create(user);
    }
}
