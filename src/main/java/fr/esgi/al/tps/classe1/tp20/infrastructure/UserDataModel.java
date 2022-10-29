package fr.esgi.al.tps.classe1.tp20.infrastructure;

import fr.esgi.al.tps.classe1.tp20.domain.User;

// DTO : a data container for the UserDAO
public final class UserDataModel {
    public final String username;
    public final String city;

    public UserDataModel(String username, String city) {
        this.username = username;
        this.city = city;
    }

    public static UserDataModel create(User user) {
        return new UserDataModel(user.getUsername(), user.getAddress().getCity());
    }
}
