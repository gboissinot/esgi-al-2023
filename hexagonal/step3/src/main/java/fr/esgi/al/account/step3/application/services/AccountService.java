package fr.esgi.al.account.step3.application.services;

import fr.esgi.al.account.step3.application.AccountApplicationException;
import fr.esgi.al.account.step3.application.port.out.AccountRepository;
import fr.esgi.al.account.step3.domain.AccountConfiguration;
import fr.esgi.al.account.step3.domain.AccountId;
import fr.esgi.al.account.step3.domain.Money;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public void sendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {

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
