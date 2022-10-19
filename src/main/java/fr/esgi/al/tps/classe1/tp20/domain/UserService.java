package fr.esgi.al.tps.classe1.tp20.domain;

import java.util.Optional;

// Application service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.add(user);
    }

    public void changeAddress(String userId, Address newAddress) {
        final Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new IllegalArgumentException("Invalid user id");
        }
        final User user = optionalUser.get();
        user.changeAddress(newAddress);
        userRepository.add(user);
    }
}
