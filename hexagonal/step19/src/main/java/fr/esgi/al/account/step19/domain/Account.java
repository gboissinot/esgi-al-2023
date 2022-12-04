package fr.esgi.al.account.step19.domain;

import fr.esgi.al.kernel.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Account {

    private final AccountId accountId;
    private final List<Event> recordedEvents;

    public Account(AccountId accountId, Money initialMoney) {
        this.accountId = accountId;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new AccountCreated(accountId, initialMoney));
    }

    public Account(AccountId accountId, List<Event> events) {
        this.accountId = accountId;
        this.recordedEvents = events;
    }

    public void deposit(Money amount) {
        this.recordedEvents.add(new AccountMoneyDeposited(accountId, amount));
    }

    public void withdraw(Money amount) {
        this.recordedEvents.add(new AccountMoneyWithdrawn(accountId, amount));
    }

    public AccountId id() {
        return accountId;
    }

    public List<Event> getRecordedEvents() {
        return Collections.unmodifiableList(recordedEvents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId);
    }
}
