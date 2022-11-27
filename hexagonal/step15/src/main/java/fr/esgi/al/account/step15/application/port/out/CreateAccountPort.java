package fr.esgi.al.account.step15.application.port.out;

import fr.esgi.al.account.step15.domain.Account;
import fr.esgi.al.account.step15.domain.AccountId;

public interface CreateAccountPort {
    AccountId nextId();

    void save(Account account);
}
