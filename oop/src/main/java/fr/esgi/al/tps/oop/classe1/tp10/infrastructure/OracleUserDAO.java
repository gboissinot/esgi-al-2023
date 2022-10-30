package fr.esgi.al.tps.oop.classe1.tp10.infrastructure;

import fr.esgi.al.tps.oop.classe1.tp10.domain.UserDAO;

public final class OracleUserDAO implements UserDAO {

    @Override
    public void createUser(String username) {
        //Technical code
        System.out.println("FROM ORACLE " + username);
    }
}
