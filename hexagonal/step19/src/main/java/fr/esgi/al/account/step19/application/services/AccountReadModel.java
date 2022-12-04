package fr.esgi.al.account.step19.application.services;

import fr.esgi.al.account.step19.domain.*;
import fr.esgi.al.kernel.Event;

import java.util.List;

public class AccountReadModel {

    private final AccountId id;
    //Mutable state
    private Money balance;

    public AccountReadModel(AccountId id, Money balance) {
        this.id = id;
        this.balance = balance;
    }

    public static AccountReadModel from(Account account) {
        var accountReadModel = new AccountReadModel(account.id(), Money.of(0d));
        accountReadModel.replay(account.getRecordedEvents());
        return accountReadModel;
    }

    private void replay(List<Event> events) {
        for (Event event : events) {
            if (event instanceof AccountCreated) {
                apply((AccountCreated) event);
            }
            if (event instanceof AccountMoneyDeposited) {
                apply((AccountMoneyDeposited) event);
            }
            if (event instanceof AccountMoneyWithdrawn) {
                apply((AccountMoneyWithdrawn) event);
            }
        }
    }

    private void apply(AccountCreated event) {
        this.balance = this.balance.add(event.getAmount());
    }

    private void apply(AccountMoneyDeposited event) {
        this.balance = this.balance.add(event.getAmount());
    }

    private void apply(AccountMoneyWithdrawn event) {
        this.balance = this.balance.minus(event.getAmount());
    }

    public Money balance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("[id=%s,balance=%,.2f]", id.value(), balance.value());
    }
}
