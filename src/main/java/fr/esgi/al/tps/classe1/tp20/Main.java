package fr.esgi.al.tps.classe1.tp20;

import fr.esgi.al.tps.classe1.tp20.domain.Address;
import fr.esgi.al.tps.classe1.tp20.domain.User;
import fr.esgi.al.tps.classe1.tp20.domain.UserService;
import fr.esgi.al.tps.classe1.tp20.exposition.CreateUserRequest;
import fr.esgi.al.tps.classe1.tp20.exposition.UserController;
import fr.esgi.al.tps.classe1.tp20.infrastructure.InMemoryUserRepository;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        var userRepository = new InMemoryUserRepository();
        var userController = new UserController(new UserService(userRepository));

        var userId = userRepository.nextId();
        userController.create(new CreateUserRequest(userId, "GREGORY", "ALFORTVILLE"));

        final Optional<User> optionalUser = userRepository.findById(userId);
        final User user = optionalUser.get();
        System.out.println(user);

        userController.changeAddress(userId, new Address("PARIS"));

        userRepository.findById(userId).ifPresent(user1 -> System.out.println(user1));
    }
}
