package fr.esgi.al.account.step7.application;

import fr.esgi.al.account.step7.domain.AccountId;
import fr.esgi.al.account.step7.domain.Money;

public final class AccountApplicationException extends RuntimeException {

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
