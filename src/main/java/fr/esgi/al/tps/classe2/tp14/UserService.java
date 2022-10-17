package fr.esgi.al.tps.classe2.tp14;

final class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    void create(UserRequest userRequest) {
        User user = new User(userRequest.lastname, userRequest.firstname);
        userDao.create(user);
    }
}
