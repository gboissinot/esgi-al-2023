package fr.esgi.al.account.step19.application.events;

import fr.esgi.al.account.step19.domain.AccountId;
import fr.esgi.al.account.step19.domain.Money;
import fr.esgi.al.kernel.Event;

public class AccountCreatedApplicationEvent implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountCreatedApplicationEvent(AccountId accountId, Money amount) {
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
