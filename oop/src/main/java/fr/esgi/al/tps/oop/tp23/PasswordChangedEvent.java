package fr.esgi.al.tps.oop.tp23;

public class PasswordChangedEvent implements Event {

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
