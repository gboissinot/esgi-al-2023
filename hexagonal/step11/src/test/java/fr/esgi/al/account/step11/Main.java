package fr.esgi.al.account.step11;

import fr.esgi.al.account.step11.adapter.in.AccountController;
import fr.esgi.al.account.step11.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.esgi.al.account.step11.application.services.CreateAccountService;
import fr.esgi.al.account.step11.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step11.application.services.SendMoneyService;
import fr.esgi.al.account.step11.domain.AccountConfiguration;
import fr.esgi.al.account.step11.domain.Money;

public class Main {
    public static void main(String[] args) {

        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        var accountController =
                new AccountController(
                        new CreateAccountService(persistenceAdapter),
                        new SendMoneyService(new AccountConfiguration(5000), persistenceAdapter, persistenceAdapter),
                        new GetAccountBalanceService(persistenceAdapter));

        var accountId1 = accountController.create(Money.of(200));
        var accountId2 = accountController.create(Money.of(100));
        var balance1 = accountController.getBalance(accountId1);
        var balance2 = accountController.getBalance(accountId2);
        System.out.printf("T1 - (%s,%s) has balance (%s,%s)", accountId1, accountId2, balance1.value(), balance2.value());

        System.out.printf("T2 - Move 30 from %s to %s.", accountId1, accountId2);
        accountController.transfer(accountId1, accountId2, Money.of(30));

        balance1 = accountController.getBalance(accountId1);
        balance2 = accountController.getBalance(accountId2);
        System.out.printf("T3 - (%s,%s) has balance (%s,%s)", accountId1, accountId2, balance1.value(), balance2.value());

    }
}
