package fr.esgi.al.tps.oop.classe2.tp00;

public class ChangePasswordService {

    private final EventDispatcher eventDispatcher;

    public ChangePasswordService(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void changePassword(String newPassword) {
        this.eventDispatcher.dispatch(new UserPasswordChanged(newPassword));
    }
}
