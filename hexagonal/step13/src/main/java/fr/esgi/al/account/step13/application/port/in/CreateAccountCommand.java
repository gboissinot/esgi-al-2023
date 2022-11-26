package fr.esgi.al.account.step13.application.port.in;

import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateAccountCommand implements Command<CreateAccountCommand> {

    @NotNull
    public final double initialMoney;

    public CreateAccountCommand(double initialMoney) {
        this.initialMoney = initialMoney;
    }
}
