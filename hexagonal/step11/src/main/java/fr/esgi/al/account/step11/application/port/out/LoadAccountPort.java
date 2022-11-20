package fr.esgi.al.account.step11.application.port.out;

import fr.esgi.al.account.step11.domain.Account;
import fr.esgi.al.account.step11.domain.AccountId;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId);
}
