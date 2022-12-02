package fr.esgi.al.account.step10.application.port.in;

import fr.esgi.al.account.step10.domain.Money;
import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public final class CreateAccountCommand implements Command {

    @NotNull
    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = initialMoney;
        validate(this);
    }
}
