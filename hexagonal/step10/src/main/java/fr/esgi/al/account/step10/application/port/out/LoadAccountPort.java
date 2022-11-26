package fr.esgi.al.account.step10.application.port.out;

import fr.esgi.al.account.step10.domain.Account;
import fr.esgi.al.account.step10.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
