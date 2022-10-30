package fr.esgi.al.tps.oop.classe2.tp6;

import java.util.UUID;

final class User {

    private final String id;
    private final String lastname;
    private final String firstname;

    private User(String id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public static User of(String lastname, String firstname) {
        return new User(UUID.randomUUID().toString(), lastname, firstname);
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
