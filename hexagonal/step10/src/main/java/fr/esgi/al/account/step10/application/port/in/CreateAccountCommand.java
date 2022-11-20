package fr.esgi.al.account.step10.application.port.in;

import fr.esgi.al.account.step10.domain.Money;
import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateAccountCommand implements Command<CreateAccountCommand> {

    @NotNull
    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = initialMoney;
        validate(this);
    }
}
