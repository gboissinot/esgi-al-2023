package fr.esgi.al.tps.oop.classe2.tp6;

public class Main {

    public static void main(String[] args) {
        var userRepository = new InMemoryUserRepository();
        var userService = new UserService(userRepository);
        var user = User.of("BOISSINOT", "GREGORY");
        userService.register(user);
        System.out.println(userService.get(user));
    }
}
