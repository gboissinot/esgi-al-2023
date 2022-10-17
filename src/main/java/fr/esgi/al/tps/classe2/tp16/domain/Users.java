package fr.esgi.al.tps.classe2.tp16.domain;

import fr.esgi.al.tps.classe2.tp16.domain.model.User;

//Repository
public interface Users {
    void add(User user);
    void delete(User user);
    User getById(String id);
}
