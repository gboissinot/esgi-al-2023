package fr.esgi.al.account.step13;

import fr.esgi.al.account.step13.adapter.in.AccountController;
import fr.esgi.al.account.step13.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step13.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step13.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step13.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step13.application.services.CreateAccountService;
import fr.esgi.al.account.step13.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step13.application.services.SendMoneyService;
import fr.esgi.al.account.step13.domain.AccountConfiguration;
import fr.esgi.al.account.step13.domain.Money;
import fr.esgi.al.kernel.BusFactory;

public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var persistenceAdapter = new AccountPersistenceAdapter();
        var createAccountPort = persistenceAdapter;
        var loadAccountPort = persistenceAdapter;
        var updateAccountStatePort = persistenceAdapter;

        var createAccountUseCase = new CreateAccountService(createAccountPort);
        var sendMoneyUseCase = new SendMoneyService(accountConfiguration, loadAccountPort, updateAccountStatePort);

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, sendMoneyUseCase);
        commandBus.register(CreateAccountCommand.class, createAccountUseCase);

        var queryBus = BusFactory.defaultQueryBus();
        var accountBalanceUseCase = new GetAccountBalanceService(loadAccountPort);
        queryBus.register(AccountBalanceQuery.class, accountBalanceUseCase);

        var accountController = new AccountController(commandBus, queryBus);

        var accountId1 = accountController.create(Money.of(250));
        var accountId2 = accountController.create(Money.of(50));

        accountController.transfer(accountId1, accountId2, Money.of(50));

        var newLoadedAccount1 = accountController.getBalance(accountId1);
        var newLoadedAccount2 = accountController.getBalance(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}