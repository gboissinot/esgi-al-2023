package fr.esgi.al.tps.classe1.tp19.exposition;

import fr.esgi.al.tps.classe1.tp19.domain.UserService;

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
}
