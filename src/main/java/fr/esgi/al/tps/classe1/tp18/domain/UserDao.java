package fr.esgi.al.tps.classe1.tp18.domain;

public interface UserDao {

    void find(UserDataModel user);

    void create(UserDataModel user);

    void delete(UserDataModel user);

    void update(UserDataModel user);
}
