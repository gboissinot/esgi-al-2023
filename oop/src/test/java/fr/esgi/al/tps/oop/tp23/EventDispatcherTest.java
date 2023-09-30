package fr.esgi.al.tps.oop.tp23;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
 class EventDispatcherTest {

    @Mock
    private EventDispatcher eventDispatcher;

    @Test
    void it_dispatch_a_user_password_changed_event() {
        UserId userId1 = new UserId("1");
        User user = new User(userId1, "Greg", "123");
        UserRepository userRepository = new InMemoryUserRepository(new HashMap<>());
        userRepository.save(user);

        UserService userService = new UserService(userRepository,eventDispatcher);
        userService.changePassword(userId1,"new password");
        verify(eventDispatcher, times(1)).dispatch(new PasswordChangedEvent());
    }
}


