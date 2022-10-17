package fr.esgi.al.tps.classe2.tp16.infrastructure;

import fr.esgi.al.tps.classe2.tp16.domain.Users;
import fr.esgi.al.tps.classe2.tp16.domain.model.User;

public final class MySQLUsers implements Users {

    @Override
    public void add(User user) {
        System.out.println("MYSQL Insert ou update");
    }

    @Override
    public void delete(User user) {
        System.out.println("MYSQL delete");
    }

    @Override
    public User getById(String id) {
        throw new UnsupportedOperationException();
    }
}
