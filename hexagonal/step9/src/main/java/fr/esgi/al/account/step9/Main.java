package fr.esgi.al.account.step9;

import fr.esgi.al.account.step9.adapter.in.AccountController;
import fr.esgi.al.account.step9.adapter.out.InMemoryAccountPersistenceAdapter;
import fr.esgi.al.account.step9.application.services.CreateAccountService;
import fr.esgi.al.account.step9.application.services.SendMoneyService;
import fr.esgi.al.account.step9.domain.AccountConfiguration;
import fr.esgi.al.account.step9.domain.Money;

public class Main {
    public static void main(String[] args) {
        var persistenceAdapter = new InMemoryAccountPersistenceAdapter();
        AccountController accountController =
                new AccountController(
                        new CreateAccountService(persistenceAdapter),
                        new SendMoneyService(new AccountConfiguration(5000), persistenceAdapter, persistenceAdapter));

        accountController.create(Money.of(50));
    }
}
