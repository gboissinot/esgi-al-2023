package fr.esgi.al.tps.classe1.tp21.domain;

import java.util.Objects;

//Entity
public class User {

    private final String id;
    private final String username;
    private Address address;

    public User(String id, String username, Address address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public void changeAddress(Address address) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, address);
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
