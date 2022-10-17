package fr.esgi.al.tps.classe2.tp00;

public class UserPasswordChanged implements Event {
    public UserPasswordChanged(String newPassword) {
    }

    @Override
    public int hashCode() {
        return 5;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
