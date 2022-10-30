package fr.esgi.al.tps.oop.classe2.tp00;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserChangePasswordTest {

    @Mock
    private EventDispatcher eventDispatcher;

    @Test
    public void test() {

        ChangePasswordService changePasswordService = new ChangePasswordService(eventDispatcher);
        changePasswordService.changePassword("new password");
        verify(eventDispatcher, times(1)).dispatch(new UserPasswordChanged("new password") );
    }
}
