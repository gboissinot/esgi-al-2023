package fr.esgi.al.tps.classe1.tp18.infrastructure;

import fr.esgi.al.tps.classe1.tp18.domain.User;

// DTO : a data container for the UserDAO
public class UserDataModel {
    public final String username;

    public UserDataModel(String username) {
        this.username = username;
    }

    public static UserDataModel create(User user) {
        return new UserDataModel(user.getUsername());
    }
}
