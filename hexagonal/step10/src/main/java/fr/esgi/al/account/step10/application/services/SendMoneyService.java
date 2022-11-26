package fr.esgi.al.account.step10.application.services;

import fr.esgi.al.account.step10.application.AccountApplicationException;
import fr.esgi.al.account.step10.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step10.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step10.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step10.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step10.domain.AccountConfiguration;
import fr.esgi.al.account.step10.domain.Money;

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
    public void sendMoney(SendMoneyCommand sendMoneyCommand) {

        var sourceAccountId = sendMoneyCommand.sourceAccountId;
        var targetAccountId = sendMoneyCommand.targetAccountId;
        var amount = sendMoneyCommand.amount;
        if (mayNotTransfer(amount)) {
            throw AccountApplicationException.exceededThreshold(sourceAccountId, targetAccountId, amount);
        }

        var sourceAccount = loadAccountPort.load(sourceAccountId);
        var targetAccount = loadAccountPort.load(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        updateAccountStatePort.update(sourceAccount);
        updateAccountStatePort.update(targetAccount);
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
