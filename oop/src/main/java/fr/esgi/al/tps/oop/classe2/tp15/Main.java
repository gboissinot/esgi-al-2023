package fr.esgi.al.tps.oop.classe2.tp15;

import fr.esgi.al.tps.oop.classe2.tp15.exposition.UserController;
import fr.esgi.al.tps.oop.classe2.tp15.exposition.UserRequest;
import fr.esgi.al.tps.oop.classe2.tp15.infrastructure.MySQLUserDao;
import fr.esgi.al.tps.oop.classe2.tp15.services.UserService;

public class Main {

    public static void main(String[] args) {
        var userRequest = new UserRequest("BOISSINOT", "GREGORY");
        var userController = new UserController(new UserService(new MySQLUserDao()));
        userController.createUser(userRequest);
    }
}
