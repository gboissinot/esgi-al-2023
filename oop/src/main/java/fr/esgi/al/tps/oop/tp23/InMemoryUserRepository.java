package fr.esgi.al.tps.oop.tp23;

import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<UserId, User> usersMap;

    public InMemoryUserRepository(Map<UserId, User> usersMap) {
        this.usersMap = usersMap;
    }

    @Override
    public User getById(UserId id) {
        return usersMap.get(id);
    }

    @Override
    public void save(User user) {
        usersMap.put(user.getId(), user);
    }
}
