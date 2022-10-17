package fr.esgi.al.tps.classe2.tp16;

import fr.esgi.al.tps.classe2.tp16.exposition.ChangeUserRequest;
import fr.esgi.al.tps.classe2.tp16.exposition.UserController;
import fr.esgi.al.tps.classe2.tp16.exposition.UserRequest;
import fr.esgi.al.tps.classe2.tp16.infrastructure.MySQLUsers;
import fr.esgi.al.tps.classe2.tp16.services.UserService;

public class Main {

    public static void main(String[] args) {
        var userRequest = new UserRequest("BOISSINOT", "GREGORY");
        final UserController userController = new UserController(new UserService(new MySQLUsers()));
        userController.createUser(userRequest);

        final ChangeUserRequest changeUserRequest = new ChangeUserRequest("BOISSINOT", "NEW NAME");
        userController.changeLastName(changeUserRequest);


    }
}
