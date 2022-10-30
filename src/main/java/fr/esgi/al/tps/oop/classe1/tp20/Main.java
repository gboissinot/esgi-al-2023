package fr.esgi.al.tps.oop.classe1.tp20;

import fr.esgi.al.tps.oop.classe1.tp20.domain.Address;
import fr.esgi.al.tps.oop.classe1.tp20.domain.User;
import fr.esgi.al.tps.oop.classe1.tp20.domain.UserService;
import fr.esgi.al.tps.oop.classe1.tp20.exposition.CreateUserRequest;
import fr.esgi.al.tps.oop.classe1.tp20.exposition.UserController;
import fr.esgi.al.tps.oop.classe1.tp20.infrastructure.InMemoryUserRepository;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        var userRepository = new InMemoryUserRepository();
        var userController = new UserController(new UserService(userRepository));

        userController.create(new CreateUserRequest("GREGORY", "ALFORTVILLE"));

        final Optional<User> optionalUser = userRepository.findByUsername("GREGORY");
        var user = optionalUser.get();
        System.out.println(user);

        userController.changeAddress(user.getId(), new Address("PARIS"));

        userRepository.findById(user.getId()).ifPresent(user1 -> System.out.println(user1));
    }
}
