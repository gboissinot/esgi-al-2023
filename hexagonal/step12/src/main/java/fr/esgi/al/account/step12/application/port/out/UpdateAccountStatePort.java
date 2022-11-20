package fr.esgi.al.account.step12.application.port.out;

import fr.esgi.al.account.step12.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
