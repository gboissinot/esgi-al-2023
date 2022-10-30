package fr.esgi.al.tps.oop.classe1.tp10;

import fr.esgi.al.tps.oop.classe1.tp10.domain.UserService;

public class Main {

    public static void main(String[] args) {
        //Apply the DI
        UserService userService = new UserService(username -> System.out.println("INLINE " + username));
        userService.createUser("GREGORY");
    }
}
