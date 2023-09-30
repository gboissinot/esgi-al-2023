package fr.esgi.al.tps.oop.tp9.infrastructure;

import fr.esgi.al.tps.oop.tp9.domain.UserDAO;

//Implementation for the DIP
public final class MySQLUserDAO implements UserDAO {

    @Override
    public void create(String username, String password) {
        //TODO Technical code to implement insertion into MySQL
        System.out.println("MYSQL creation.");
    }
}
