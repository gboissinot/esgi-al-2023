package fr.esgi.al.account.step10;

import fr.esgi.al.account.step10.adapter.in.AccountController;
import fr.esgi.al.account.step10.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.esgi.al.account.step10.application.services.CreateAccountService;
import fr.esgi.al.account.step10.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step10.application.services.SendMoneyService;
import fr.esgi.al.account.step10.domain.AccountConfiguration;
import fr.esgi.al.account.step10.domain.AccountId;
import fr.esgi.al.account.step10.domain.Money;

public class Main {
    public static void main(String[] args) {
        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        AccountController accountController =
                new AccountController(
                        new CreateAccountService(persistenceAdapter),
                        new SendMoneyService(new AccountConfiguration(5000), persistenceAdapter, persistenceAdapter),
                        new GetAccountBalanceService(persistenceAdapter));

        final AccountId accountId = accountController.create(Money.of(50));

        final Money balance = accountController.getBalance(accountId);
        System.out.println(balance.value());

    }
}
