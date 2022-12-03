package fr.esgi.al.account.step18.application.services;

import fr.esgi.al.account.step18.application.events.AccountCreatedApplicationEvent;
import fr.esgi.al.account.step18.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step18.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step18.domain.Account;
import fr.esgi.al.account.step18.domain.Money;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final CreateAccountPort createAccountPort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateAccountService(CreateAccountPort createAccountPort, EventDispatcher<? super Event> eventDispatcher) {
        this.createAccountPort = createAccountPort;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var initialMoney = Money.of(command.initialMoney);
        var account = new Account(accountId, initialMoney);
        createAccountPort.save(account);
        eventDispatcher.dispatch(new AccountCreatedApplicationEvent(accountId, initialMoney));
        return accountId.value();
    }
}
