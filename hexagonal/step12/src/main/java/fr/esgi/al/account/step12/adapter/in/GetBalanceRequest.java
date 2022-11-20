package fr.esgi.al.account.step12.adapter.in;

import javax.validation.constraints.NotNull;

public class GetBalanceRequest {
    @NotNull
    public String accountId;
}
