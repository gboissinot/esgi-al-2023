package com.esgi.al.microservices.graphql.api;

import com.esgi.al.microservices.graphql.domain.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.stream.Collectors;

@Controller
public class UserQuery {

    private final UserRepository userRepository;

    @Autowired
    public UserQuery(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping(value = "user")
    public UserResponse getUserById(@Argument Long id) {
        var user = userRepository.getById(id);
        return UserResponse.of(user);
    }

    @SchemaMapping(typeName = "Query", value = "findUsers")
    public Iterable<UserResponse> listAll() {
        return userRepository
                .findAll()
                .stream()
                .map(UserResponse::of).collect(Collectors.toList());
    }
}
