package fr.esgi.al.account.step18.application.services;

import fr.esgi.al.account.step18.application.AccountApplicationException;
import fr.esgi.al.account.step18.application.events.TransferAcceptedApplicationEvent;
import fr.esgi.al.account.step18.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step18.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step18.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step18.domain.AccountConfiguration;
import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.account.step18.domain.Money;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class SendMoneyService implements CommandHandler<SendMoneyCommand, Void> {

    private final AccountConfiguration accountConfiguration;
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;
    private final EventDispatcher<? super Event> eventDispatcher;

    public SendMoneyService(AccountConfiguration accountConfiguration, LoadAccountPort loadAccountPort, UpdateAccountStatePort updateAccountStatePort, EventDispatcher<? super Event> eventDispatcher) {
        this.accountConfiguration = accountConfiguration;
        this.loadAccountPort = loadAccountPort;
        this.updateAccountStatePort = updateAccountStatePort;
        this.eventDispatcher = eventDispatcher;
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

        eventDispatcher.dispatch(new TransferAcceptedApplicationEvent(sourceAccountId, targetAccountId, amount));

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
