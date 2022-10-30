package fr.esgi.al.tps.oop.classe1.tp7;

import java.util.List;

public interface UserRepository {
    User getById(String id);

    void save(User user);

    List<User> findAll();
}
