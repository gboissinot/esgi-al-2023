package fr.esgi.al.tps.classe2.tp7;

public class ChangePasswordService {

    private final EventDispatcher eventDispatcher;

    public ChangePasswordService(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }

    public void changePassword(String newPassword){
        this.eventDispatcher.dispatch(new UserPasswordChanged(newPassword));
    }
}
