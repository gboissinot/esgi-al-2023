package fr.esgi.al.tps.classe1.tp7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> myData = new HashMap<>();

    @Override
    public User getById(String id) {
        return myData.get(id);
    }

    @Override
    public void save(User user) {
        myData.put(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(myData.values());
    }
}
