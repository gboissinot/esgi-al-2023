package fr.esgi.al.tps.classe1.tp19.domain;

import java.util.UUID;

// Application service
public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(String username, String city) {
        var user = new User(UUID.randomUUID().toString(), username, new Address(city));
        userRepository.save(user);
    }
}
