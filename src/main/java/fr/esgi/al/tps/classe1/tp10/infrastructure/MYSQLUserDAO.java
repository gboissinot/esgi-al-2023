package fr.esgi.al.tps.classe1.tp10.infrastructure;

import fr.esgi.al.tps.classe1.tp10.domain.UserDAO;

public class MYSQLUserDAO implements UserDAO {

    @Override
    public  void createUser(String username){
        //Technical code
        System.out.println("FROM MYSQL " + username );
    }
}