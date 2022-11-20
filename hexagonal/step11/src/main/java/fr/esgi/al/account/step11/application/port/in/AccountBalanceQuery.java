package fr.esgi.al.account.step11.application.port.in;

import fr.esgi.al.account.step11.domain.AccountId;
import fr.esgi.al.kernel.Query;

import javax.validation.constraints.NotNull;

public class AccountBalanceQuery implements Query<AccountBalanceQuery> {

    @NotNull
    public final AccountId accountId;

    public AccountBalanceQuery(AccountId accountId) {
        this.accountId = accountId;
    }
}
