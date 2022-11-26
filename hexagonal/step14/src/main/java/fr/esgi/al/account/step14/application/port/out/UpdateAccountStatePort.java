package fr.esgi.al.account.step14.application.port.out;

import fr.esgi.al.account.step14.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
