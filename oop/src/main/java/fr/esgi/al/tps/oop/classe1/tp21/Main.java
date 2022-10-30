package fr.esgi.al.tps.oop.classe1.tp21;

import fr.esgi.al.tps.oop.classe1.tp21.domain.Address;
import fr.esgi.al.tps.oop.classe1.tp21.domain.User;
import fr.esgi.al.tps.oop.classe1.tp21.domain.UserService;
import fr.esgi.al.tps.oop.classe1.tp21.exposition.CreateUserRequest;
import fr.esgi.al.tps.oop.classe1.tp21.exposition.UserController;
import fr.esgi.al.tps.oop.classe1.tp21.infrastructure.InMemoryUsers;

public class Main {

    public static void main(String[] args) {

        var userRepository = new InMemoryUsers();
        var userController = new UserController(new UserService(userRepository));

        userController.create(new CreateUserRequest("GREGORY", "ALFORTVILLE"));

        final User user = userRepository.findByUsername("GREGORY");
        System.out.println(user);

        userController.changeAddress(user.getId(), new Address("PARIS"));

        final User user1 = userRepository.findById(user.getId());
        System.out.println(user1);
    }
}
