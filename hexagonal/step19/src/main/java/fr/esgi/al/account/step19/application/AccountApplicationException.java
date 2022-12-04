package fr.esgi.al.account.step18.application;

import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.account.step18.domain.Money;
import fr.esgi.al.kernel.ApplicationException;

public final class AccountApplicationException extends ApplicationException {

    private AccountApplicationException(String message) {
        super(message);
    }

    public static AccountApplicationException exceededThreshold(AccountId accountId1, AccountId accountId2, Money money) {
        return new AccountApplicationException(String.format("[account1=%s,account2=%s,balance=%,.2f] transfer cannot be executed.",
                accountId1.value(),
                accountId2.value(),
                money.value()));
    }
}
