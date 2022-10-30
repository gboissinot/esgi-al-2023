package fr.esgi.al.tps.oop.classe1.tp7;

public class Main {
    public static void main(String[] args) {
        var userRepository = new StubInMemoryUserRepository();
        var userService = new UserService(userRepository);
        userService.create(new User("5", "FRED"));
        userService.create(new User("6", "JOHN"));
        userService.all().forEach(System.out::println);
    }
}
