package fr.esgi.al.account.step17.application.events;

import fr.esgi.al.account.step17.domain.AccountId;
import fr.esgi.al.account.step17.domain.Money;
import fr.esgi.al.kernel.Event;

public final class TransferAcceptedEvent implements Event {

    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final Money amount;

    public TransferAcceptedEvent(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }

    public AccountId getSourceAccountId() {
        return sourceAccountId;
    }

    public AccountId getTargetAccountId() {
        return targetAccountId;
    }

    public Money getAmount() {
        return amount;
    }
}
