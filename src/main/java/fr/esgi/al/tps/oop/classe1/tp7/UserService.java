package fr.esgi.al.tps.oop.classe1.tp7;

import java.util.List;

final class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> all() {
        return userRepository.findAll();
    }
}
