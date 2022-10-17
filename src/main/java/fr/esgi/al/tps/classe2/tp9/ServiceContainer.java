package fr.esgi.al.tps.classe2.tp9;

import fr.esgi.al.tps.classe2.tp9.domain.UserDAO;
import fr.esgi.al.tps.classe2.tp9.domain.UserService;
import fr.esgi.al.tps.classe2.tp9.infrastructure.MySQLUserDAO;

//USE IOC
public final class ServiceContainer {

    public static UserService getUserService() {
        UserDAO userDAO = new MySQLUserDAO();
        //Use DI
        return new UserService(userDAO);
    }
}
