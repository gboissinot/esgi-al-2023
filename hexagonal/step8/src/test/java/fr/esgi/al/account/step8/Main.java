package fr.esgi.al.account.step8;

import fr.esgi.al.account.step8.adapter.in.AccountController;
import fr.esgi.al.account.step8.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.esgi.al.account.step8.application.services.CreateAccountService;
import fr.esgi.al.account.step8.application.services.SendMoneyService;
import fr.esgi.al.account.step8.domain.AccountConfiguration;
import fr.esgi.al.account.step8.domain.Money;

public class Main {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        var accountConfiguration = new AccountConfiguration(1000L);

        var accountPersistenceAdapter = new InMemoryAccountPersistenceAdapter();
        var loadAccountPort = accountPersistenceAdapter;
        var createAccountPort = accountPersistenceAdapter;
        var updateAccountStatePort = accountPersistenceAdapter;

        var createAccountUseCase = new CreateAccountService(createAccountPort);
        var sendMoneyUseCase = new SendMoneyService(accountConfiguration, loadAccountPort, updateAccountStatePort);

        var accountController = new AccountController(createAccountUseCase, sendMoneyUseCase);

        var accountId1 = accountController.create(Money.of(250));
        var accountId2 = accountController.create(Money.of(50));

        accountController.transfer(accountId1, accountId2, Money.of(50));

        var newLoadedAccount1 = loadAccountPort.load(accountId1);
        var newLoadedAccount2 = loadAccountPort.load(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
