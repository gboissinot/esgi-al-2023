package fr.esgi.al.tps.oop.tp6;

final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get(User user) {
        return userRepository.getById(user.getId());
    }

    public void register(User user) {
        userRepository.save(user);
    }
}
