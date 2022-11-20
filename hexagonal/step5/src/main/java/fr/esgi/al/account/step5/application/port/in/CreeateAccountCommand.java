package fr.esgi.al.account.step5.application.port.in;

import fr.esgi.al.account.step5.domain.Money;

public class CreeateAccountCommand {

    public final Money initialMoney;

    public CreeateAccountCommand(Money initialMoney) {
        this.initialMoney = initialMoney;
    }
}
