package fr.esgi.al.tps.classe1.tp7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StubInMemoryUserRepository implements UserRepository {

    private final Map<String, User> preConfiguredData = Map.of(
            "1", new User("1", "GREGORY"),
            "2", new User("2", "JANIE"),
            "3", new User("3", "WILLY")

    );

    @Override
    public User getById(String id) {
        return preConfiguredData.get(id);
    }

    @Override
    public void save(User user) {
        //Do nothing
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(preConfiguredData.values());
    }
}
