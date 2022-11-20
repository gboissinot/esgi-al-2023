package fr.esgi.al.account.step5.application.services;

import fr.esgi.al.account.step5.application.port.in.CreeateAccountCommand;
import fr.esgi.al.account.step5.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step5.application.port.out.AccountRepository;
import fr.esgi.al.account.step5.domain.Account;
import fr.esgi.al.account.step5.domain.AccountConfiguration;
import fr.esgi.al.account.step5.domain.Money;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public void createAccount(CreeateAccountCommand creeateAccountCommand) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, creeateAccountCommand.initialMoney);
        accountRepository.save(account);
    }

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
