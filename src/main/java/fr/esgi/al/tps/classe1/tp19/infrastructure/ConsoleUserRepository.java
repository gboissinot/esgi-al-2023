package fr.esgi.al.tps.classe1.tp19.infrastructure;

import fr.esgi.al.tps.classe1.tp19.domain.User;
import fr.esgi.al.tps.classe1.tp19.domain.UserRepository;

public final class ConsoleUserRepository implements UserRepository {
    @Override
    public void save(User user) {
        //Use potentially a UserDataModel
        UserDataModel userDataModel = UserDataModel.create(user);

        System.out.println("Saving user");
    }
}
