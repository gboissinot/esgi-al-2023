package fr.esgi.al.tps.classe1.tp15;

import java.util.UUID;

// Application service
public class UserService {

    public void create(CreateUserRequest createUserRequest) {
        User user = new User(UUID.randomUUID().toString(),
                createUserRequest.username);
        //Make User creation
    }
}
