package fr.esgi.al.tps.classe1.tp18.domain;

// DTO : a data container for the UserDAO
public final class UserDataModel {
    public final String username;

    private UserDataModel(String username) {
        this.username = username;
    }

    public static UserDataModel of(User user) {
        return new UserDataModel(user.getUsername());
    }
}
