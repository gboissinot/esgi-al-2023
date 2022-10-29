package fr.esgi.al.tps.classe1.tp20.infrastructure;

import fr.esgi.al.tps.classe1.tp20.domain.User;
import fr.esgi.al.tps.classe1.tp20.domain.UserRepository;

import java.util.*;

public final class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void add(User user) {
        userMap.putIfAbsent(user.getId(), user);
    }

    @Override
    public Optional<User> findById(String id) {
        var user = userMap.get(id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        List<User> users = new ArrayList<>();
        for (User user : this.userMap.values()) {
            if (user.getUsername().equals(username)) {
                users.add(user);
            }
        }
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }
}
