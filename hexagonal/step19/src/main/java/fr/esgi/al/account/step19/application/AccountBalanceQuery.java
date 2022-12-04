package fr.esgi.al.account.step19.application;

import fr.esgi.al.kernel.Query;

import javax.validation.constraints.NotNull;

public final class AccountBalanceQuery implements Query {

    @NotNull
    public final String accountId;

    public AccountBalanceQuery(String accountId) {
        this.accountId = accountId;
    }
}
