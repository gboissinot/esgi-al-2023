package fr.esgi.al.tps.classe1.tp19.domain;

// Application service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.save(user);
    }
}
