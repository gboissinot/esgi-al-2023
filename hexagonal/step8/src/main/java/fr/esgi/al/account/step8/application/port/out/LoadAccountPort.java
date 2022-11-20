package fr.esgi.al.account.step8.application.port.out;

import fr.esgi.al.account.step8.domain.Account;
import fr.esgi.al.account.step8.domain.AccountId;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId);
}
