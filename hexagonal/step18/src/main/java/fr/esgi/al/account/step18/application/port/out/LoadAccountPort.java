package fr.esgi.al.account.step18.application.port.out;

import fr.esgi.al.account.step18.domain.Account;
import fr.esgi.al.account.step18.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}