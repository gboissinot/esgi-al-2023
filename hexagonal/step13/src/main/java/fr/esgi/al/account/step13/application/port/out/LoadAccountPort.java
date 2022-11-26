package fr.esgi.al.account.step13.application.port.out;

import fr.esgi.al.account.step13.domain.Account;
import fr.esgi.al.account.step13.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
