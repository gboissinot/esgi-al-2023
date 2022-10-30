package fr.esgi.al.tps.oop.classe2.tp15.exposition;

import fr.esgi.al.tps.oop.classe2.tp15.domain.model.User;
import fr.esgi.al.tps.oop.classe2.tp15.services.UserService;

public final class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserRequest userRequest) {
        User user = new User(userRequest.lastname, userRequest.firstname);
        userService.create(user);
    }
}
