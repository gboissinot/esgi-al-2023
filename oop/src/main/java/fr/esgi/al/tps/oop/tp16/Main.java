package fr.esgi.al.tps.oop.tp16;

import fr.esgi.al.tps.oop.tp16.exposition.ChangeUserRequest;
import fr.esgi.al.tps.oop.tp16.exposition.CreateUserRequest;
import fr.esgi.al.tps.oop.tp16.exposition.UserController;
import fr.esgi.al.tps.oop.tp16.infrastructure.MySQLUsers;
import fr.esgi.al.tps.oop.tp16.services.UserService;

public class Main {

    public static void main(String[] args) {
        var userRequest = new CreateUserRequest("BOISSINOT", "GREGORY");
        var userController = new UserController(new UserService(new MySQLUsers()));
        userController.createUser(userRequest);

        final ChangeUserRequest changeUserRequest = new ChangeUserRequest("BOISSINOT", "NEW NAME");
        userController.changeLastName(changeUserRequest);


    }
}
