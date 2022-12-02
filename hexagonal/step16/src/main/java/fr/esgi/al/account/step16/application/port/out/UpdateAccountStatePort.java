package fr.esgi.al.account.step16.application.port.out;

import fr.esgi.al.account.step16.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
