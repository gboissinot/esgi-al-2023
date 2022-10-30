package fr.esgi.al.tps.oop.classe2.tp16.exposition;

import fr.esgi.al.tps.oop.classe2.tp16.services.UserService;

public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(CreateUserRequest createUserRequest) {
        //DTO Validation
        if (createUserRequest.lastname == null) {
            throw new IllegalArgumentException("A user lastname is required.");
        }

        userService.create(createUserRequest.lastname, createUserRequest.firstname);
    }

    public void changeLastName(ChangeUserRequest userRequest) {
        userService.changeUser(userRequest.id, userRequest.newLastName);
    }
}
