package fr.esgi.al.account.step9.application.port.out;

import fr.esgi.al.account.step9.domain.Account;
import fr.esgi.al.account.step9.domain.AccountId;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId);
}
