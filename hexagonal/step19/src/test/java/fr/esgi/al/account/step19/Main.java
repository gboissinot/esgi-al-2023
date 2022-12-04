package fr.esgi.al.account.step19;

import fr.esgi.al.account.step19.application.AccountBalanceQuery;
import fr.esgi.al.account.step19.application.CreateAccountCommand;
import fr.esgi.al.account.step19.application.SendMoneyCommand;
import fr.esgi.al.account.step19.application.events.AccountCreatedApplicationEvent;
import fr.esgi.al.account.step19.application.events.AccountCreatedEventHandler;
import fr.esgi.al.account.step19.application.events.TransferAcceptedApplicationEvent;
import fr.esgi.al.account.step19.application.events.TransferAcceptedEventHandler;
import fr.esgi.al.account.step19.application.services.CreateAccountService;
import fr.esgi.al.account.step19.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step19.application.services.SendMoneyService;
import fr.esgi.al.account.step19.domain.AccountConfiguration;
import fr.esgi.al.account.step19.infrastructure.InMemoryAccounts;
import fr.esgi.al.account.step19.infrastructure.LogNotifications;
import fr.esgi.al.kernel.BusFactory;
import fr.esgi.al.kernel.DefaultEventDispatcher;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var accounts = new InMemoryAccounts();

        var eventDispatcher = DefaultEventDispatcher.create();
        var notifications = new LogNotifications();
        var transferAcceptedEventHandler = new TransferAcceptedEventHandler(notifications);
        var accountCreatedEventHandler = new AccountCreatedEventHandler(notifications);
        eventDispatcher.register(TransferAcceptedApplicationEvent.class, transferAcceptedEventHandler);
        eventDispatcher.register(AccountCreatedApplicationEvent.class, accountCreatedEventHandler);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, new SendMoneyService(accountConfiguration, accounts, eventDispatcher));
        commandBus.register(CreateAccountCommand.class, new CreateAccountService(accounts, eventDispatcher));

        var queryBus = BusFactory.defaultQueryBus();
        queryBus.register(AccountBalanceQuery.class, new GetAccountBalanceService(accounts));

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
