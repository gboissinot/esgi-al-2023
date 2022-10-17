package fr.esgi.al.tps.classe2.tp14;

public class Main {

    public static void main(String[] args) {
        var userRequest = new UserRequest("BOISSINOT", "GREGORY");
        var userService = new UserService(new MySQLUserDao());
        userService.create(userRequest);
    }
}
