package fr.esgi.al.tps.classe1.tp17.exposition;

import fr.esgi.al.tps.classe1.tp17.domain.UserService;

//Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void create(CreateUserRequest createUserRequest) {
        //DTO Validation
        if (createUserRequest.username == null) {
            throw new IllegalArgumentException("A username is required.");
        }

        userService.create(createUserRequest.username, createUserRequest.city);
    }
}
