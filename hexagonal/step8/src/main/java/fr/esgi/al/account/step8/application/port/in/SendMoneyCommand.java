package fr.esgi.al.account.step8.application.port.in;

import fr.esgi.al.account.step8.domain.AccountId;
import fr.esgi.al.account.step8.domain.Money;

import java.util.Objects;

public class SendMoneyCommand {

    public final AccountId sourceAccountId;
    public final AccountId targetAccountId;
    public final Money amount;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = Objects.requireNonNull(sourceAccountId);
        this.targetAccountId = Objects.requireNonNull(targetAccountId);
        this.amount = Objects.requireNonNull(amount);
    }
}
