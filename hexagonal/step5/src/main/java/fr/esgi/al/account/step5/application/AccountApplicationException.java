package fr.esgi.al.account.step5.application;

import fr.esgi.al.account.step5.domain.AccountException;
import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

public final class AccountApplicationException extends AccountException {

    private AccountApplicationException(String message) {
        super(message);
    }

    public static AccountApplicationException notFoundAccountId(AccountId accountId) {
        return new AccountApplicationException(String.format("%s not found.", accountId.value()));
    }

    public static AccountApplicationException cannotTransfer(AccountId accountId1, AccountId accountId2, Money money) {
        return new AccountApplicationException(String.format("[account1=%s,account2=%s,balance=%,.2f] transfer cannot be executed.",
                accountId1.value(),
                accountId2.value(),
                money.value()));
    }
}
