package fr.esgi.al.tps.classe1.tp10.domain;

public final class UserService {

    //Use the DIP
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(String username) {
        userDAO.createUser(username);
    }
}
