package fr.esgi.al.tps.oop.tp6;

import java.util.HashMap;
import java.util.Map;

final class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap();

    @Override
    public User getById(String id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }
}
