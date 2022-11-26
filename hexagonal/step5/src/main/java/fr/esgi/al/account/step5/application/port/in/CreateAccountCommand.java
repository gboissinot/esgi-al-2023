package fr.esgi.al.account.step5.application.port.in;

import fr.esgi.al.account.step5.domain.Money;

import java.util.Objects;

public final class CreateAccountCommand {

    public final Money initialMoney;

    public CreateAccountCommand(Money initialMoney) {
        this.initialMoney = Objects.requireNonNull(initialMoney);
    }
}
