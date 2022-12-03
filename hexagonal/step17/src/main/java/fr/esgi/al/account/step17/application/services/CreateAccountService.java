package fr.esgi.al.account.step17.application.services;

import fr.esgi.al.account.step17.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step17.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step17.domain.Account;
import fr.esgi.al.account.step17.domain.Money;
import fr.esgi.al.kernel.CommandHandler;

public final class CreateAccountService implements CommandHandler<CreateAccountCommand, String> {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public String handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, Money.of(command.initialMoney));
        createAccountPort.save(account);
        return accountId.value();
    }
}
