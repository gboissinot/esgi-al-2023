package fr.esgi.al.account.step4.application.services;

import fr.esgi.al.account.step4.application.port.out.AccountRepository;
import fr.esgi.al.account.step4.domain.Account;
import fr.esgi.al.account.step4.domain.AccountConfiguration;
import fr.esgi.al.account.step4.domain.AccountId;
import fr.esgi.al.account.step4.domain.Money;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public void createAccount(Money initialMoney) {
        var accountId = accountRepository.nextId();
        var account = new Account(accountId, initialMoney);
        accountRepository.save(account);
    }

    public void sendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {

        if (mayNotTransfer(amount)) {
            throw new RuntimeException();
        }

        final Account sourceAccount = accountRepository.findBy(sourceAccountId);
        final Account targetAccount = accountRepository.findBy(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
