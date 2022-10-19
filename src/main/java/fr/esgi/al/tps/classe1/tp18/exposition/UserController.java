package fr.esgi.al.tps.classe1.tp18.exposition;

import fr.esgi.al.tps.classe1.tp18.domain.Address;
import fr.esgi.al.tps.classe1.tp18.domain.User;
import fr.esgi.al.tps.classe1.tp18.domain.UserService;

import java.util.UUID;

//Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void create(CreateUserRequest createUserRequest) {
        //Validation of DTO
        if (createUserRequest.username == null) {
            throw new IllegalArgumentException("A username is required.");
        }

        User user = new User(UUID.randomUUID().toString(),
                createUserRequest.username, new Address(createUserRequest.city));
        userService.create(user);
    }
}
