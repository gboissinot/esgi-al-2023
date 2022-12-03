package fr.esgi.al.account.step17.application.port.out;

import fr.esgi.al.account.step17.domain.Account;
import fr.esgi.al.account.step17.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
