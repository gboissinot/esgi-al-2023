package fr.esgi.al.tps.oop.tp23;

public class User {

    private UserId id;
    private String name;
    private String hashedPassword;

    public User(UserId id, String name, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void changePassword(String newHashedPassword) {
        this.hashedPassword=newHashedPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
