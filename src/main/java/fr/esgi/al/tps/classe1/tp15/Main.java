package fr.esgi.al.tps.classe1.tp15;

public class Main {

    public static void main(String[] args) {
        CreateUserRequest createUserRequest = new CreateUserRequest("GREGORY");
        UserService userService = new UserService();
        userService.create(createUserRequest);
    }
}
