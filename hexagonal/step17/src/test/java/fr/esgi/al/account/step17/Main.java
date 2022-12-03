package fr.esgi.al.account.step17;

import fr.esgi.al.account.step17.adapter.in.AccountController;
import fr.esgi.al.account.step17.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.esgi.al.account.step17.adapter.out.LogNotifications;
import fr.esgi.al.account.step17.application.events.AccountCreatedEvent;
import fr.esgi.al.account.step17.application.events.TransferAcceptedEvent;
import fr.esgi.al.account.step17.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step17.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step17.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step17.application.services.*;
import fr.esgi.al.account.step17.domain.AccountConfiguration;
import fr.esgi.al.kernel.BusFactory;
import fr.esgi.al.kernel.DefaultEventDispatcher;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        var createAccountPort = persistenceAdapter;
        var loadAccountPort = persistenceAdapter;
        var updateAccountStatePort = persistenceAdapter;

        var eventDispatcher = DefaultEventDispatcher.create();
        var notifications = new LogNotifications();
        var transferAcceptedEventHandler = new TransferAcceptedEventHandler(notifications);
        var accountCreatedEventHandler = new AccountCreatedEventHandler(notifications);
        eventDispatcher.register(TransferAcceptedEvent.class, transferAcceptedEventHandler);
        eventDispatcher.register(AccountCreatedEvent.class, accountCreatedEventHandler);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, new SendMoneyService(accountConfiguration, loadAccountPort, updateAccountStatePort, eventDispatcher));
        commandBus.register(CreateAccountCommand.class, new CreateAccountService(createAccountPort, eventDispatcher));

        var queryBus = BusFactory.defaultQueryBus();
        queryBus.register(AccountBalanceQuery.class, new GetAccountBalanceService(loadAccountPort));

        var accountController = new AccountController(commandBus, queryBus);

        var accountId1 = accountController.create(250);
        var accountId2 = accountController.create(50);

        accountController.transfer(accountId1, accountId2, 50);

        var newLoadedAccount1 = accountController.getBalance(accountId1);
        var newLoadedAccount2 = accountController.getBalance(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
