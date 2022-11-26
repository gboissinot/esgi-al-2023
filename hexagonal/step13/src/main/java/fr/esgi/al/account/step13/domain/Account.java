package fr.esgi.al.account.step13.domain;

import java.util.Objects;

public final class Account {

    private final AccountId accountId;
    private Money balance;

    public Account(AccountId accountId, Money balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void deposit(Money money) {
        this.balance = this.balance.add(money);
    }

    public void withdraw(Money money) {
        this.balance = this.balance.minus(money);
    }

    public AccountId id() {
        return accountId;
    }

    public Money balance() {
        return balance;
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

    @Override
    public String toString() {
        return String.format("[id=%s,balance=%,.2f]", id().value(), balance.value());
    }
}
