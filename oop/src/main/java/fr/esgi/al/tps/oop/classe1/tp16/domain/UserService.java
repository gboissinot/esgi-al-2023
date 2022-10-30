package fr.esgi.al.tps.oop.classe1.tp16.domain;

import java.util.UUID;

// Application service
public final class UserService {

    public void create(String username) {
        //User creation
        User user = new User(UUID.randomUUID().toString(), username);
        System.out.println("[UserService] - create - " + user);
    }
}
