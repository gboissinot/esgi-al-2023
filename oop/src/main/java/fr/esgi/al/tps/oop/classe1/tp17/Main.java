package fr.esgi.al.tps.oop.classe1.tp17;

import fr.esgi.al.tps.oop.classe1.tp17.domain.UserService;
import fr.esgi.al.tps.oop.classe1.tp17.exposition.CreateUserRequest;
import fr.esgi.al.tps.oop.classe1.tp17.exposition.UserController;
import fr.esgi.al.tps.oop.classe1.tp17.infrastructure.ConsoleAddressDAO;
import fr.esgi.al.tps.oop.classe1.tp17.infrastructure.ConsoleUserDao;

public class Main {

    public static void main(String[] args) {
        var userController =
                new UserController(
                        new UserService(
                                new ConsoleUserDao(), new ConsoleAddressDAO()));
        userController.create(new CreateUserRequest("GREGORY", "ALFORTVILLE"));
    }
}
