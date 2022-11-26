package fr.esgi.al.account.step7.application.services;

import fr.esgi.al.account.step7.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step7.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step7.application.port.out.AccountRepository;
import fr.esgi.al.account.step7.domain.Account;
import fr.esgi.al.account.step7.domain.AccountId;

public class CreateAccountService implements CreateAccountUseCase {

    private final AccountRepository accountRepository;

    public CreateAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountId createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        accountRepository.save(account);
        return accountId;
    }
}
