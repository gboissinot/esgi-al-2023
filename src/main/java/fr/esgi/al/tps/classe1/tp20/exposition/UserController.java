package fr.esgi.al.tps.classe1.tp20.exposition;

import fr.esgi.al.tps.classe1.tp20.domain.Address;
import fr.esgi.al.tps.classe1.tp20.domain.User;
import fr.esgi.al.tps.classe1.tp20.domain.UserRepository;
import fr.esgi.al.tps.classe1.tp20.domain.UserService;

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

        User user = new User(
                createUserRequest.id,
                createUserRequest.username,
                new Address(createUserRequest.city));
        userService.create(user);
    }

    public void changeAddress(String userId, Address newAddress) {
        userService.changeAddress(userId,newAddress);
    }
}
