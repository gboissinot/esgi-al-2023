package fr.esgi.al.account.step13.application.port.in;

import fr.esgi.al.kernel.Query;

import javax.validation.constraints.NotNull;

public class AccountBalanceQuery implements Query<AccountBalanceQuery> {

    @NotNull
    public final String accountId;

    public AccountBalanceQuery(String accountId) {
        this.accountId = accountId;
    }
}
