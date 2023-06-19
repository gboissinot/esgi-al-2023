package com.esgi.al.microservices.graphql.domain.model;

import java.util.List;

public interface UserRepository {

    Long nextIdentity();

    void save(User user);

    User getById(Long id);

    List<User> findAll();

}
