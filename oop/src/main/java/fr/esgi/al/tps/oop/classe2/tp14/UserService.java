package fr.esgi.al.tps.oop.classe2.tp14;

final class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    void create(CreateUserRequest createUserRequest) {
        User user = new User(createUserRequest.lastname, createUserRequest.firstname);
        userDao.create(user);
    }
}
