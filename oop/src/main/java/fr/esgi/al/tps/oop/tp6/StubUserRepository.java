package fr.esgi.al.tps.oop.tp6;

import java.util.Map;

final class StubUserRepository implements UserRepository {

    private Map<String, User> myData = Map.of(
            "1", User.of("BOISSINOT", "GREGORY"),
            "2", User.of("BOISSINOT", "JANIE"),
            "3", User.of("BOISSINOT", "WILLY")
    );

    @Override
    public User getById(String id) {
        return myData.get(id);
    }

    @Override
    public void save(User user) {
        throw new UnsupportedOperationException();
    }
}
