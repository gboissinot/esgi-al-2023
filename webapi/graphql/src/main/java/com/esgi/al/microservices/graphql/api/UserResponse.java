package com.esgi.al.microservices.graphql.api;

import com.esgi.al.microservices.graphql.domain.model.User;

public class UserResponse {

    public Long id;
    public String fullname;
    public AddressResponse address;

    public UserResponse(Long id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public UserResponse(Long id, String fullname, AddressResponse address) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
    }

    public static UserResponse of(User user) {
        var address = user.address();
        return new UserResponse(user.id(),
                user.firstname() + " " + user.lastname(),
                new AddressResponse(address.zipCode(), address.city()));
    }
}
