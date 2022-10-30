package fr.esgi.al.tps.oop.classe2.tp14;

public class Main {

    public static void main(String[] args) {
        var userRequest = new CreateUserRequest("BOISSINOT", "GREGORY");
        var userService = new UserService(new MySQLUserDao());
        userService.create(userRequest);
    }
}
