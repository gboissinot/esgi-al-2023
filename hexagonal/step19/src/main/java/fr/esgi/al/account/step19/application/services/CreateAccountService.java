package fr.esgi.al.account.step19.application.services;

import fr.esgi.al.account.step19.application.CreateAccountCommand;
import fr.esgi.al.account.step19.application.events.AccountCreatedApplicationEvent;
import fr.esgi.al.account.step19.domain.Account;
import fr.esgi.al.account.step19.domain.Accounts;
import fr.esgi.al.account.step19.domain.Money;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final Accounts accounts;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateAccountService(Accounts accounts, EventDispatcher<? super Event> eventDispatcher) {
        this.accounts = accounts;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = accounts.nextId();
        var initialMoney = Money.of(command.initialMoney);
        var account = new Account(accountId, initialMoney);
        accounts.add(account);
        eventDispatcher.dispatch(new AccountCreatedApplicationEvent(accountId, initialMoney));
        return accountId.value();
    }
}
