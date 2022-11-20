package fr.esgi.al.account.step3.application.port.out;

import fr.esgi.al.account.step3.domain.Account;
import fr.esgi.al.account.step3.domain.AccountId;

public interface AccountRepository {
    Account findBy(AccountId accountId);

    void save(Account targetAccount);
}
