package fr.esgi.al.account.step15.application.port.out;

import fr.esgi.al.account.step15.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
