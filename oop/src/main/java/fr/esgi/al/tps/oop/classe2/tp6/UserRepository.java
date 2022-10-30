package fr.esgi.al.tps.oop.classe2.tp6;

public interface UserRepository {
    User getById(String id);

    void save(User user);
}
