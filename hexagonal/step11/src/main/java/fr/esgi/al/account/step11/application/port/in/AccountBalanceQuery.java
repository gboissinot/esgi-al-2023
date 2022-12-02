package fr.esgi.al.account.step11.application.port.in;

import fr.esgi.al.account.step11.domain.AccountId;
import fr.esgi.al.kernel.Query;

import javax.validation.constraints.NotNull;

public final class AccountBalanceQuery implements Query {

    @NotNull
    public final AccountId accountId;

    public AccountBalanceQuery(AccountId accountId) {
        this.accountId = accountId;
        validate(this);
    }
}
