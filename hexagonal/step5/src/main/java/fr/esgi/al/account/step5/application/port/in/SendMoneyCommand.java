package fr.esgi.al.account.step5.application.port.in;

import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

public class SendMoneyCommand {

    public final AccountId sourceAccountId;
    public final AccountId targetAccountId;
    public final Money amount;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }
}
