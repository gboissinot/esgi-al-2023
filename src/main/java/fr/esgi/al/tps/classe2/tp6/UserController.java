package fr.esgi.al.tps.classe2.tp6;

public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(User user) {
        return userRepository.getById(user.getId());
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
