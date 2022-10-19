package fr.esgi.al.tps.classe1.tp18.infrastructure;

import fr.esgi.al.tps.classe1.tp18.domain.UserDao;

public class ConsoleUserDao implements UserDao {
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
