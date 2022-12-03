package fr.esgi.al.account.step17.adapter.in;

import javax.validation.constraints.NotNull;

public final class CreateAccountRequest {
    @NotNull
    public long amount;
}
