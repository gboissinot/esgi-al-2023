package fr.esgi.al.account.step14.adapter.in;

import javax.validation.constraints.NotNull;

public class CreateAccountRequest {
    @NotNull
    public long amount;
}
