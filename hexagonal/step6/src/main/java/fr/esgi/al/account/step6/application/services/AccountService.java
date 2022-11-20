package fr.esgi.al.account.step6.application.services;

import fr.esgi.al.account.step6.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step6.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step6.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step6.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step6.application.port.out.AccountRepository;
import fr.esgi.al.account.step6.domain.Account;
import fr.esgi.al.account.step6.domain.AccountConfiguration;
import fr.esgi.al.account.step6.domain.Money;

public final class AccountService implements CreateAccountUseCase, SendMoneyUseCase {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(CreateAccountCommand createAccountCommand) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, createAccountCommand.initialMoney);
        accountRepository.save(account);
    }

    @Override
    public void sendMoney(SendMoneyCommand sendMoneyCommand) {

        var amount = sendMoneyCommand.amount;
        if (mayNotTransfer(amount)) {
            throw new RuntimeException();
        }

        final Account sourceAccount = accountRepository.findBy(sendMoneyCommand.sourceAccountId);
        final Account targetAccount = accountRepository.findBy(sendMoneyCommand.targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
