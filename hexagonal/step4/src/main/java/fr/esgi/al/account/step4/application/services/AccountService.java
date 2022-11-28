package fr.esgi.al.account.step4.application.services;

import fr.esgi.al.account.step4.application.AccountApplicationException;
import fr.esgi.al.account.step4.application.port.out.AccountRepository;
import fr.esgi.al.account.step4.domain.Account;
import fr.esgi.al.account.step4.domain.AccountConfiguration;
import fr.esgi.al.account.step4.domain.AccountId;
import fr.esgi.al.account.step4.domain.Money;

import java.util.Objects;

public final class AccountService {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public AccountService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
    }

    public AccountId createAccount(Money initialMoney) {

        checkCreateAccountAction(initialMoney);

        var accountId = accountRepository.nextId();
        var account = new Account(accountId, initialMoney);
        accountRepository.save(account);
        return accountId;
    }

    private void checkCreateAccountAction(Money initialMoney) {
        Objects.requireNonNull(initialMoney);
    }

    public void sendMoney(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {

        checkSendMoneyAction(sourceAccountId, targetAccountId, amount);

        var sourceAccount = accountRepository.findById(sourceAccountId);
        var targetAccount = accountRepository.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    private void checkSendMoneyAction(AccountId sourceAccountId, AccountId targetAccountId, Money amount) {
        Objects.requireNonNull(sourceAccountId);
        Objects.requireNonNull(targetAccountId);
        Objects.requireNonNull(amount);
        if (!amount.isPositive()) {
            throw AccountApplicationException.wrongTransferMoney(amount);
        }

        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
