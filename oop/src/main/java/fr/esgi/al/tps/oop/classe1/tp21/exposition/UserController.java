package fr.esgi.al.tps.oop.classe1.tp21.exposition;

import fr.esgi.al.tps.oop.classe1.tp21.domain.Address;
import fr.esgi.al.tps.oop.classe1.tp21.domain.UserService;

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

        userService.create(createUserRequest.username, createUserRequest.city);
    }

    public void changeAddress(String userId, Address newAddress) {
        userService.changeAddress(userId, newAddress);
    }
}
