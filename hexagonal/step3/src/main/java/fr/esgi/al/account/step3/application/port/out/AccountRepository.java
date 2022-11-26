package fr.esgi.al.account.step3.application.port.out;

import fr.esgi.al.account.step3.domain.Account;
import fr.esgi.al.account.step3.domain.AccountId;

public interface AccountRepository {
    Account findById(AccountId accountId);

    void save(Account account);
}
