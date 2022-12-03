package fr.esgi.al.account.step17.application.port.out;

import fr.esgi.al.account.step17.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
