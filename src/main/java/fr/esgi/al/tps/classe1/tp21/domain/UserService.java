package fr.esgi.al.tps.classe1.tp21.domain;

// Application service
public class UserService {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    /**
     * Creates the user
     *
     * @param username the given username
     * @param city     the given city address
     */
    public void create(String username, String city) {
        var userId = users.nextId();
        User user = new User(userId, username, new Address(city));
        users.add(user);
    }

    /**
     * Changes user address
     *
     * @param userId     the given user identifier
     * @param newAddress the new address
     * @throws {@link NoSuchUserException} if the user is not present.
     */
    public void changeAddress(String userId, Address newAddress) {
        var user = users.findById(userId);
        user.changeAddress(newAddress);
        users.add(user);
    }
}
