package fr.esgi.al.tps.oop.tp23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var mailListener= new MailListener();
        var eventDispatcher = new DefaultEventDispatcher(
                Map.of(PasswordChangedEvent.class, List.of(mailListener))
        );

        UserId userId1 = new UserId("1");
        User user = new User(userId1, "Greg", "123");
        UserRepository userRepository = new InMemoryUserRepository(new HashMap<>());
        userRepository.save(user);

        UserService userService = new UserService(userRepository,eventDispatcher);

        userService.changePassword(userId1, "124");

        var extractedUser = userRepository.getById(userId1);
        System.out.println(extractedUser);

    }
}
