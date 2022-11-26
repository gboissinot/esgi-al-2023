package fr.esgi.al.account.step13.adapter.in;

import javax.validation.constraints.NotNull;

public class CreateAccountRequest {
    @NotNull
    public long amount;
}
