package fr.esgi.al.account.step17.application.events;

import fr.esgi.al.account.step17.domain.AccountId;
import fr.esgi.al.account.step17.domain.Money;
import fr.esgi.al.kernel.Event;

public class AccountCreatedEvent implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountCreatedEvent(AccountId accountId, Money amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public Money getAmount() {
        return amount;
    }
}
