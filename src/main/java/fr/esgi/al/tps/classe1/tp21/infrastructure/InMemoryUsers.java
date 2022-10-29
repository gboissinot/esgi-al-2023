package fr.esgi.al.tps.classe1.tp21.infrastructure;

import fr.esgi.al.tps.classe1.tp21.domain.NoSuchUserException;
import fr.esgi.al.tps.classe1.tp21.domain.User;
import fr.esgi.al.tps.classe1.tp21.domain.Users;

import java.util.*;

public class InMemoryUsers implements Users {

    private Map<String, User> userMap = new HashMap<>();

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void add(User user) {
        userMap.putIfAbsent(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        var user = userMap.get(id);
        if (user == null) {
            throw new NoSuchUserException();
        }
        return user;
    }

    @Override
    public User findByUsername(String username) throws NoSuchUserException {
        List<User> users = new ArrayList<>();
        for (User user : this.userMap.values()) {
            if (user.getUsername().equals(username)) {
                users.add(user);
            }
        }
        if (users.isEmpty()) {
            throw new NoSuchUserException();
        }
        return users.get(0);
    }
}
