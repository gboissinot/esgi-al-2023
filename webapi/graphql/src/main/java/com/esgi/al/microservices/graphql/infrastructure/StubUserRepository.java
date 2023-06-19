package com.esgi.al.microservices.graphql.infrastructure;

import com.esgi.al.microservices.graphql.domain.model.Address;
import com.esgi.al.microservices.graphql.domain.model.User;
import com.esgi.al.microservices.graphql.domain.model.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Component
public class StubUserRepository implements UserRepository {

    private final AtomicLong counter = new AtomicLong(3);

    private Address alfortvilleAddress = new Address("94140", "ALFORTVILLE");
    private Map<Long, User> data =
            Map.of(
                    1L, new User(1L, "BOISSINOT", "GREGORY", alfortvilleAddress),
                    2L, new User(2L, "BOISSINOT", "JANIE", alfortvilleAddress),
                    3L, new User(3L, "BOISSINOT", "WILLY", alfortvilleAddress)
            );

    @Override
    public Long nextIdentity() {
        return counter.incrementAndGet();
    }

    @Override
    public void save(User user) {
        data = new HashMap<>(data);
        data.put(user.id(), user);
    }

    @Override
    public User getById(Long id) {
        return data.get(id);
    }

    @Override
    public List<User> findAll() {
        return data.values().stream().collect(Collectors.toList());
    }
}
