package fr.esgi.al.tps.classe2.tp6;

public class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new StubUserRepository();

        UserController userController = new UserController(userRepository);
        final User user = User.of("BOISSINOT", "GREGORY");

        userController.register(user);

        System.out.println(userController.get(user));
    }
}
