package fr.esgi.al.account.step18.domain;

import fr.esgi.al.kernel.Event;

public class AccountMoneyDeposited implements Event {

    private final AccountId accountId;
    private final Money amount;

    public AccountMoneyDeposited(AccountId accountId, Money amount) {
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
