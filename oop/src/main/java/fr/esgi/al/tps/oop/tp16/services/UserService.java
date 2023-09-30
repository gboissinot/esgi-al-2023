package fr.esgi.al.tps.oop.tp16.services;

import fr.esgi.al.tps.oop.tp16.domain.Users;
import fr.esgi.al.tps.oop.tp16.domain.model.User;

public final class UserService {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    public void create(String lastname, String firstname) {
        User user = new User(lastname, lastname, firstname);
        users.add(user);
    }

    public void changeUser(String userId, String newLastName) {
        var user = users.getById(userId);
        user.changeLastName(newLastName);
        users.add(user);
    }
}
