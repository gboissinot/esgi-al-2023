package fr.esgi.al.account.step14.application.port.out;

import fr.esgi.al.account.step14.domain.Account;
import fr.esgi.al.account.step14.domain.AccountId;

public interface LoadAccountPort {
    Account load(AccountId accountId);
}
