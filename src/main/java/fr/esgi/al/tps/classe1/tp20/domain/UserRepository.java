package fr.esgi.al.tps.classe1.tp20.domain;

import java.util.Optional;

public interface UserRepository {

    String nextId();

    void add(User user);

    Optional<User> findById(String id);
}
