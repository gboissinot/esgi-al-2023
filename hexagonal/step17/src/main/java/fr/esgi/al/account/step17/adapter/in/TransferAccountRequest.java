package fr.esgi.al.account.step17.adapter.in;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public final class TransferAccountRequest {
    @NotNull
    public String sourceAccountId;
    @NotNull
    public String targetAccountId;
    @Positive
    public double amount;
}
