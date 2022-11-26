package fr.esgi.al.account.step14.application.services;

import fr.esgi.al.account.step14.application.AccountApplicationException;
import fr.esgi.al.account.step14.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step14.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step14.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step14.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step14.domain.AccountConfiguration;
import fr.esgi.al.account.step14.domain.AccountId;
import fr.esgi.al.account.step14.domain.Money;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class SendMoneyService implements SendMoneyUseCase {

    private final AccountConfiguration accountConfiguration;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;

    public SendMoneyService(AccountConfiguration accountConfiguration, LoadAccountPort loadAccountPort, UpdateAccountStatePort updateAccountStatePort) {
        this.accountConfiguration = accountConfiguration;
        this.loadAccountPort = loadAccountPort;
        this.updateAccountStatePort = updateAccountStatePort;
    }

    @Override
    public Void handle(SendMoneyCommand sendMoneyCommand) {

        var sourceAccountId = AccountId.of(UUID.fromString(sendMoneyCommand.sourceAccountId));
        var targetAccountId = AccountId.of(UUID.fromString(sendMoneyCommand.targetAccountId));
        var amount = Money.of(sendMoneyCommand.amount);
        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }

        var sourceAccount = loadAccountPort.load(sourceAccountId);
        var targetAccount = loadAccountPort.load(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        updateAccountStatePort.update(sourceAccount);
        updateAccountStatePort.update(targetAccount);

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
