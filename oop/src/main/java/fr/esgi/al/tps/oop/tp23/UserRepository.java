package fr.esgi.al.tps.oop.tp23;

public interface UserRepository {

    User getById(UserId id);

    void save(User user);
}
