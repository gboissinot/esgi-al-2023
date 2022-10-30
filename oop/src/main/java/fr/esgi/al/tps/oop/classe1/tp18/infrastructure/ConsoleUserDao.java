package fr.esgi.al.tps.oop.classe1.tp18.infrastructure;

import fr.esgi.al.tps.oop.classe1.tp18.domain.UserDao;
import fr.esgi.al.tps.oop.classe1.tp18.domain.UserDataModel;

public final class ConsoleUserDao implements UserDao {
    @Override
    public void find(UserDataModel user) {
        System.out.println("[ConsoleUserDao] - find");
    }

    @Override
    public void create(UserDataModel user) {
        System.out.println("[ConsoleUserDao] - create");
    }

    @Override
    public void delete(UserDataModel user) {
        System.out.println("[ConsoleUserDao] - delete");
    }

    @Override
    public void update(UserDataModel user) {
        System.out.println("[ConsoleUserDao] - update");
    }
}
