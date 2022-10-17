package fr.esgi.al.tps.classe2.tp9;

import fr.esgi.al.tps.classe2.tp9.domain.UserService;

public class Main {
    public static void main(String[] args) {
        final UserService userService = ServiceContainer.getUserService();
        userService.createUser("GREGORY", "admin123");
    }
}
