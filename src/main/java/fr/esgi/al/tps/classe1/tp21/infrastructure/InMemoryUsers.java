package fr.esgi.al.tps.classe1.tp21.infrastructure;

import fr.esgi.al.tps.classe1.tp21.domain.NoSuchUserException;
import fr.esgi.al.tps.classe1.tp21.domain.User;
import fr.esgi.al.tps.classe1.tp21.domain.Users;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class InMemoryUsers implements Users {

    private Map<String, User> users = new HashMap<>();

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void add(User user) {
        users.putIfAbsent(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        var user = users.get(id);
        if (user == null) {
            throw new NoSuchUserException();
        }
        return user;
    }
}
