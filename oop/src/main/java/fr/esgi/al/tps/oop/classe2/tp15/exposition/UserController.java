package fr.esgi.al.tps.oop.classe2.tp15.exposition;

import fr.esgi.al.tps.oop.classe2.tp15.services.UserService;

public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserRequest createUserRequest) {
        //DTO Validation
        if (createUserRequest.lastname == null) {
            throw new IllegalArgumentException("A user lastname is required.");
        }
        userService.create(createUserRequest.lastname, createUserRequest.firstname);
    }
}
