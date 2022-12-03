package fr.esgi.al.account.step15.adapter.in;

import fr.esgi.al.account.step15.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step15.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step15.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step15.domain.AccountId;
import fr.esgi.al.account.step15.domain.Money;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;

public final class AccountController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public AccountController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    public AccountId create(double initialAmount) {
        return (AccountId) commandBus.post(new CreateAccountCommand(initialAmount));
    }

    public void transfer(String sourceAccountId, String targetAccountId, double amount) {
        commandBus.post(new SendMoneyCommand(sourceAccountId, targetAccountId, amount));
    }

    public Money getBalance(String accountId) {
        return (Money) queryBus.post(new AccountBalanceQuery(accountId));
    }
}
