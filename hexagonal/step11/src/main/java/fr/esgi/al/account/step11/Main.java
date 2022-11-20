package fr.esgi.al.account.step11;

import fr.esgi.al.account.step11.adapter.in.AccountController;
import fr.esgi.al.account.step11.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step11.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step11.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step11.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step11.application.services.CreateAccountService;
import fr.esgi.al.account.step11.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step11.application.services.SendMoneyService;
import fr.esgi.al.account.step11.domain.AccountConfiguration;
import fr.esgi.al.account.step11.domain.Money;
import fr.esgi.al.kernel.BusFactory;

public class Main {
    public static void main(String[] args) {

        var persistenceAdapter = new AccountPersistenceAdapter();

        var commandBus = BusFactory.defaultCommandBus();
        commandBus.register(SendMoneyCommand.class, new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter, persistenceAdapter));
        commandBus.register(CreateAccountCommand.class, new CreateAccountService(persistenceAdapter));

        var queryBus = BusFactory.defaultQueryBus();
        queryBus.register(AccountBalanceQuery.class, new GetAccountBalanceService(persistenceAdapter));

        AccountController accountController = new AccountController(commandBus, queryBus);

        var accountId1 = accountController.create(Money.of(200));
        var accountId2 = accountController.create(Money.of(100));
        var balance1 = accountController.getBalance(accountId1);
        var balance2 = accountController.getBalance(accountId2);
        System.out.println(String.format("T1 - (%s,%s) has balance (%s,%s)", accountId1, accountId2, balance1.value(), balance2.value()));

        System.out.println(String.format("T2 - Move 30 from %s to %s.", accountId1, accountId2));
        accountController.transfer(accountId1, accountId2, Money.of(30));

        balance1 = accountController.getBalance(accountId1);
        balance2 = accountController.getBalance(accountId2);
        System.out.println(String.format("T3 - (%s,%s) has balance (%s,%s)", accountId1, accountId2, balance1.value(), balance2.value()));

    }
}
