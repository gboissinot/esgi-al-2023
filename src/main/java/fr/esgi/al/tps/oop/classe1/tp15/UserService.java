package fr.esgi.al.tps.oop.classe1.tp15;

import java.util.UUID;

// Application service
final class UserService {

    public void create(CreateUserRequest createUserRequest) {
        //Make User creation
        User user = new User(UUID.randomUUID().toString(),
                createUserRequest.username);
        System.out.println("[Service] - create - " + user);
    }
}
