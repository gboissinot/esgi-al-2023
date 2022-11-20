package fr.esgi.al.account.step8.application.port.out;

import fr.esgi.al.account.step8.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
