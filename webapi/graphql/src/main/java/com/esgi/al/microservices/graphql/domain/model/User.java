package com.esgi.al.microservices.graphql.domain.model;

import java.util.Objects;

public record User(Long id, String lastname, String firstname, Address address) {
    public User {
        Objects.requireNonNull(id);
        Objects.requireNonNull(lastname);
        Objects.requireNonNull(firstname);
    }
}
