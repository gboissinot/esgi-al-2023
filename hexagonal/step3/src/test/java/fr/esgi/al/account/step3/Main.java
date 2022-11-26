package fr.esgi.al.account.step3;

import fr.esgi.al.account.step3.adapter.in.AccountController;
import fr.esgi.al.account.step3.adapter.out.InMemoryAccountRepository;
import fr.esgi.al.account.step3.application.services.AccountService;
import fr.esgi.al.account.step3.domain.Account;
import fr.esgi.al.account.step3.domain.AccountConfiguration;
import fr.esgi.al.account.step3.domain.AccountId;
import fr.esgi.al.account.step3.domain.Money;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        var accountConfiguration = new AccountConfiguration(1000L);
        var accountRepository = new InMemoryAccountRepository();
        var accountService = new AccountService(accountConfiguration, accountRepository);
        var accountController = new AccountController(accountService);

        var accountId1 = AccountId.of(UUID.randomUUID());
        var accountId2 = AccountId.of(UUID.randomUUID());
        var account1 = new Account(accountId1, Money.of(250));
        var account2 = new Account(accountId2, Money.of(50));

        accountRepository.save(account1);
        accountRepository.save(account2);

        accountController.transfer(accountId1, accountId2, Money.of(50));

        var newLoadedAccount1 = accountRepository.findById(accountId1);
        var newLoadedAccount2 = accountRepository.findById(accountId2);

        System.out.println(newLoadedAccount1);
        System.out.println(newLoadedAccount2);
    }
}
