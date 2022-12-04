package fr.esgi.al.account.step19.application;

import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public final class CreateAccountCommand implements Command {

    @NotNull
    public final double initialMoney;

    public CreateAccountCommand(double initialMoney) {
        this.initialMoney = initialMoney;
    }
}
