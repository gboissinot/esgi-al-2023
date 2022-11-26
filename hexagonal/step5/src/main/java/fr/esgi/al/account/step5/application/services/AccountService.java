package fr.esgi.al.account.step5.application.services;

import fr.esgi.al.account.step5.application.AccountApplicationException;
import fr.esgi.al.account.step5.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step5.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step5.application.port.out.AccountRepository;
import fr.esgi.al.account.step5.domain.Account;
import fr.esgi.al.account.step5.domain.AccountConfiguration;
import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public AccountId createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        accountRepository.save(account);
        return accountId;
    }

    public void sendMoney(SendMoneyCommand sendMoneyCommand) {

        var sourceAccountId = sendMoneyCommand.sourceAccountId;
        var targetAccountId = sendMoneyCommand.targetAccountId;
        var amount = sendMoneyCommand.amount;
        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.cannotTransfer(sourceAccountId, targetAccountId, amount);
        }

        var sourceAccount = accountRepository.findById(sourceAccountId);
        var targetAccount = accountRepository.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
