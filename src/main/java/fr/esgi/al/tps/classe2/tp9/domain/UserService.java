package fr.esgi.al.tps.classe2.tp9.domain;

public class UserService {

    //Use the DIP
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(String name, String password) {

        userDAO.create(name, password);

    }
}
