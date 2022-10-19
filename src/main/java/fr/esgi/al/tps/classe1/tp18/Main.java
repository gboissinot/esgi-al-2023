package fr.esgi.al.tps.classe1.tp18;

import fr.esgi.al.tps.classe1.tp18.domain.UserService;
import fr.esgi.al.tps.classe1.tp18.exposition.CreateUserRequest;
import fr.esgi.al.tps.classe1.tp18.exposition.UserController;
import fr.esgi.al.tps.classe1.tp18.infrastructure.ConsoleAddressDAO;
import fr.esgi.al.tps.classe1.tp18.infrastructure.ConsoleUserDao;

public class Main {

    public static void main(String[] args) {

        UserController userController =
                new UserController(
                        new UserService(
                                new ConsoleUserDao(), new ConsoleAddressDAO()));
        userController.create(new CreateUserRequest("GREGORY", "ALFORTVILLE"));
    }
}
