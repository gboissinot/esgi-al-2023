package fr.esgi.al.account.step19.exposition;

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
