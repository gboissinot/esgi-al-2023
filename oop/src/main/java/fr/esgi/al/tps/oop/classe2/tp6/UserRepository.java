package fr.esgi.al.tps.oop.classe2.tp6;

interface UserRepository {
    User getById(String id);

    void save(User user);
}
