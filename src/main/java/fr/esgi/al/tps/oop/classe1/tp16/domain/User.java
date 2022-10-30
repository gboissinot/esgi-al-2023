package fr.esgi.al.tps.oop.classe1.tp16.domain;

//Root Entity
public final class User {

    private final String id;
    private final String username;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
