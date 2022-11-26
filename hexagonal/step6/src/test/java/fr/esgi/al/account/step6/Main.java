package fr.esgi.al.account.step6;

import fr.esgi.al.account.step6.adapter.in.AccountController;
import fr.esgi.al.account.step6.adapter.out.InMemoryAccountRepository;
import fr.esgi.al.account.step6.application.services.AccountService;
import fr.esgi.al.account.step6.domain.AccountConfiguration;
import fr.esgi.al.account.step6.domain.Money;

public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var accountRepository = new InMemoryAccountRepository();
        var createAccountUseCase = new AccountService(accountConfiguration, accountRepository);
        var sendMoneyUseCase = new AccountService(accountConfiguration, accountRepository);
        var accountController = new AccountController(createAccountUseCase, sendMoneyUseCase);

        var accountId1 = accountController.create(Money.of(250));
        var accountId2 = accountController.create(Money.of(50));

        accountController.transfer(accountId1, accountId2, Money.of(50));

        var newLoadedAccount1 = accountRepository.findById(accountId1);
        var newLoadedAccount2 = accountRepository.findById(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
