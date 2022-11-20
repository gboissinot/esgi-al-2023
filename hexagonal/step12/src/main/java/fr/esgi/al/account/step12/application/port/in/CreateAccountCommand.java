package fr.esgi.al.account.step12.application.port.in;

import fr.esgi.al.account.step12.domain.Money;
import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateAccountCommand implements Command<CreateAccountCommand> {

    @NotNull
    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = initialMoney;
    }
}
