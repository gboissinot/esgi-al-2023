package fr.esgi.al.tps.oop.classe1.tp7;

final class User {
    private final String id;
    private final String firstname;

    public User(String id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
