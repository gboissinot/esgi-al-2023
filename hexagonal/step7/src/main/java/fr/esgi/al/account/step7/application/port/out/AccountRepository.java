package fr.esgi.al.account.step7.application.port.out;

import fr.esgi.al.account.step7.domain.Account;
import fr.esgi.al.account.step7.domain.AccountId;

public interface AccountRepository {

    AccountId nextId();

    Account findById(AccountId accountId);

    void save(Account account);
}
