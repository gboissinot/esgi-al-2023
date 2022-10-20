package fr.esgi.al.tps.classe1.tp21;

import fr.esgi.al.tps.classe1.tp21.domain.Address;
import fr.esgi.al.tps.classe1.tp21.domain.User;
import fr.esgi.al.tps.classe1.tp21.domain.UserService;
import fr.esgi.al.tps.classe1.tp21.exposition.CreateUserRequest;
import fr.esgi.al.tps.classe1.tp21.exposition.UserController;
import fr.esgi.al.tps.classe1.tp21.infrastructure.InMemoryUsers;

public class Main {

    public static void main(String[] args) {

        var userRepository = new InMemoryUsers();
        var userController = new UserController(new UserService(userRepository));

        var userId = userRepository.nextId();
        userController.create(new CreateUserRequest(userId, "GREGORY", "ALFORTVILLE"));

        final User user = userRepository.findById(userId);
        System.out.println(user);

        userController.changeAddress(userId, new Address("PARIS"));

        final User user1 = userRepository.findById(userId);
        System.out.println(user1);
    }
}
