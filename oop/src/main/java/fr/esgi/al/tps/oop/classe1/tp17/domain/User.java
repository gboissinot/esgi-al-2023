package fr.esgi.al.tps.oop.classe1.tp17.domain;

//Root Entity
public final class User {

    private final String id;
    private final String username;
    private final Address address;

    public User(String id, String username, Address address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", address=" + address +
                '}';
    }
}
