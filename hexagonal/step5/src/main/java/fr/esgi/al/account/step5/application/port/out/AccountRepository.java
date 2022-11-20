package fr.esgi.al.account.step5.application.port.out;

import fr.esgi.al.account.step5.domain.Account;
import fr.esgi.al.account.step5.domain.AccountId;

public interface AccountRepository {

    AccountId nextId();

    Account findBy(AccountId accountId);

    void save(Account account);
}
