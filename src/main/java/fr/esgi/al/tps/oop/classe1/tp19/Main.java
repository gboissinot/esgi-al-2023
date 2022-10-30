package fr.esgi.al.tps.oop.classe1.tp19;

import fr.esgi.al.tps.oop.classe1.tp19.domain.UserService;
import fr.esgi.al.tps.oop.classe1.tp19.exposition.CreateUserRequest;
import fr.esgi.al.tps.oop.classe1.tp19.exposition.UserController;
import fr.esgi.al.tps.oop.classe1.tp19.infrastructure.ConsoleUserRepository;

public class Main {

    public static void main(String[] args) {

        UserController userController =
                new UserController(
                        new UserService(
                                new ConsoleUserRepository()));
        userController.create(new CreateUserRequest("GREGORY", "ALFORTVILLE"));
    }
}
