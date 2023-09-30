package fr.esgi.al.tps.oop.tp6;

interface UserRepository {
    User getById(String id);

    void save(User user);
}
