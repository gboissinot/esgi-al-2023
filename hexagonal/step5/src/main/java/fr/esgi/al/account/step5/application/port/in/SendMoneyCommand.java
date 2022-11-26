package fr.esgi.al.account.step5.application.port.in;

import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

import java.util.Objects;

public final class SendMoneyCommand {

    public final AccountId sourceAccountId;
    public final AccountId targetAccountId;
    public final Money amount;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = Objects.requireNonNull(sourceAccountId);
        this.targetAccountId = Objects.requireNonNull(targetAccountId);
        this.amount = Objects.requireNonNull(amount);
        if (!this.amount.isPositive()) {
            throw new IllegalArgumentException();
        }
    }
}
