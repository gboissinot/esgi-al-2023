package fr.esgi.al.tps.classe1.tp10.infrastructure;

import fr.esgi.al.tps.classe1.tp10.domain.UserDAO;

public final class MySQLUserDAO implements UserDAO {

    @Override
    public void createUser(String username) {
        //Technical code
        System.out.println("FROM MYSQL " + username);
    }
}
