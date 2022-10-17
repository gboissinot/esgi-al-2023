package fr.esgi.al.tps.classe2.tp16.exposition;

import fr.esgi.al.tps.classe2.tp16.domain.model.User;
import fr.esgi.al.tps.classe2.tp16.services.UserService;

public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserRequest userRequest) {
        User user = new User(userRequest.lastname, userRequest.lastname, userRequest.firstname);
        userService.create(user);
    }

    public void changeLastName(ChangeUserRequest userRequest) {
        userService.changeUser(userRequest.id, userRequest.newLastName);
    }
}
