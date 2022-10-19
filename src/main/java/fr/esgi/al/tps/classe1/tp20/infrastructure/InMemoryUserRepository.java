package fr.esgi.al.tps.classe1.tp20.infrastructure;

import fr.esgi.al.tps.classe1.tp20.domain.User;
import fr.esgi.al.tps.classe1.tp20.domain.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryUserRepository implements UserRepository {

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
    public Optional<User> findById(String id) {
        var user = users.get(id);
        return Optional.ofNullable(user);
    }
}
