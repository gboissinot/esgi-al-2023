package fr.esgi.al.tps.classe1.tp21.domain;

// Application service
public class UserService {

    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    public void create(User user) {
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
