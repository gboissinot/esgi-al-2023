package fr.esgi.al.account.step7.application.services;

import fr.esgi.al.account.step7.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step7.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step7.application.port.out.AccountRepository;
import fr.esgi.al.account.step7.domain.Account;
import fr.esgi.al.account.step7.domain.AccountConfiguration;
import fr.esgi.al.account.step7.domain.Money;

public class SendMoneyService implements SendMoneyUseCase {

    private final AccountConfiguration accountConfiguration;
    private final AccountRepository accountRepository;

    public SendMoneyService(AccountConfiguration accountConfiguration, AccountRepository accountRepository) {
        this.accountConfiguration = accountConfiguration;
        this.accountRepository = accountRepository;
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
