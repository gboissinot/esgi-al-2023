package fr.esgi.al.tps.oop.classe2.tp14;

import java.util.Objects;

final class User {

    private final String lastname;
    private final String firstname;

    public User(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname);
    }

    @Override
    public String toString() {
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
