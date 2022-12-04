package fr.esgi.al.account.step19.exposition;

import javax.validation.constraints.NotNull;

public final class CreateAccountRequest {
    @NotNull
    public long amount;
}
