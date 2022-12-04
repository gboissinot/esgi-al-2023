package fr.esgi.al.account.step19.application.services;

import fr.esgi.al.account.step19.application.AccountApplicationException;
import fr.esgi.al.account.step19.application.SendMoneyCommand;
import fr.esgi.al.account.step19.application.events.TransferAcceptedApplicationEvent;
import fr.esgi.al.account.step19.domain.AccountConfiguration;
import fr.esgi.al.account.step19.domain.AccountId;
import fr.esgi.al.account.step19.domain.Accounts;
import fr.esgi.al.account.step19.domain.Money;
import fr.esgi.al.kernel.CommandHandler;
import fr.esgi.al.kernel.Event;
import fr.esgi.al.kernel.EventDispatcher;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public class SendMoneyService implements CommandHandler<SendMoneyCommand, Void> {

    private final AccountConfiguration accountConfiguration;
    private final Accounts accounts;
    private final EventDispatcher<? super Event> eventDispatcher;

    public SendMoneyService(AccountConfiguration accountConfiguration, Accounts accounts, EventDispatcher<? super Event> eventDispatcher) {
        this.accountConfiguration = accountConfiguration;
        this.accounts = accounts;
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

        var sourceAccount = accounts.findById(sourceAccountId);
        var targetAccount = accounts.findById(targetAccountId);

        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);

        accounts.add(sourceAccount);
        accounts.add(targetAccount);

        eventDispatcher.dispatch(new TransferAcceptedApplicationEvent(sourceAccountId, targetAccountId, amount));

        return null;
    }

    private boolean mayNotTransfer(Money amount) {
        return accountConfiguration.transferThreshold() < amount.value();
    }
}
