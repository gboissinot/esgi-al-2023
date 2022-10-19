package fr.esgi.al.tps.classe1.tp17.domain;

public interface UserDao {

    void find(User user);

    void create(User user);

    void delete(User user);

    void update(User user);
}
