package fr.esgi.al.tps.oop.classe1.tp17.infrastructure;

import fr.esgi.al.tps.oop.classe1.tp17.domain.User;
import fr.esgi.al.tps.oop.classe1.tp17.domain.UserDao;

public class ConsoleUserDao implements UserDao {
    @Override
    public void find(User user) {
        System.out.println("[ConsoleUserDao] - find");
    }

    @Override
    public void create(User user) {
        System.out.println("[ConsoleUserDao] - create");
    }

    @Override
    public void delete(User user) {
        System.out.println("[ConsoleUserDao] - delete");
    }

    @Override
    public void update(User user) {
        System.out.println("[ConsoleUserDao] - update");
    }
}
