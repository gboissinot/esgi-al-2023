package fr.esgi.al.account.step12.application.port.out;

import fr.esgi.al.account.step12.domain.Account;
import fr.esgi.al.account.step12.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
