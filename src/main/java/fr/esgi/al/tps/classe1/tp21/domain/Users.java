package fr.esgi.al.tps.classe1.tp21.domain;

public interface Users {

    String nextId();

    void add(User user);

    User findById(String id) throws NoSuchUserException;
}
