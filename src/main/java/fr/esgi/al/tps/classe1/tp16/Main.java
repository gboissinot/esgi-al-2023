package fr.esgi.al.tps.classe1.tp16;

import fr.esgi.al.tps.classe1.tp16.domain.UserService;
import fr.esgi.al.tps.classe1.tp16.exposition.CreateUserRequest;
import fr.esgi.al.tps.classe1.tp16.exposition.UserController;

public class Main {
    public static void main(String[] args) {
        var userService = new UserService();
        var controller = new UserController(userService);
        controller.create(new CreateUserRequest("GREGORY"));
    }
}
