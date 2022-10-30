package fr.esgi.al.tps.oop.classe1.tp20.exposition;

import fr.esgi.al.tps.oop.classe1.tp20.domain.Address;
import fr.esgi.al.tps.oop.classe1.tp20.domain.UserService;

//Controller
public final class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void create(CreateUserRequest createUserRequest) {
        //Validation of DTO
        if (createUserRequest.username == null) {
            throw new IllegalArgumentException("A username is required.");
        }

        userService.create(createUserRequest.username, createUserRequest.city);
    }

    public void changeAddress(String userId, Address newAddress) {
        userService.changeAddress(userId, newAddress);
    }
}
