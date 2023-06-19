package com.esgi.al.microservices.graphql.domain.model;

import java.util.Objects;

public record Address(String zipCode, String city) {
    public Address {
        Objects.requireNonNull(zipCode);
        Objects.requireNonNull(city);
    }
}
