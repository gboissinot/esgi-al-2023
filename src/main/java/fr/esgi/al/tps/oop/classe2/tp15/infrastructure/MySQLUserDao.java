package fr.esgi.al.tps.oop.classe2.tp15.infrastructure;

import fr.esgi.al.tps.oop.classe2.tp15.domain.UserDao;
import fr.esgi.al.tps.oop.classe2.tp15.domain.model.User;

public final class MySQLUserDao implements UserDao {
    @Override
    public void create(User user) {
        System.out.println("MYSQL Creation with " + user);
    }
}
