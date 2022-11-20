package fr.esgi.al.account.step10.application.port.out;

import fr.esgi.al.account.step10.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
