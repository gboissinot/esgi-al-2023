package fr.esgi.al.account.step11.application.services;

import fr.esgi.al.account.step11.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step11.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step11.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step11.domain.Account;
import fr.esgi.al.account.step11.domain.AccountId;

public final class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, command.initialMoney);
        createAccountPort.save(account);
        return accountId;
    }
}
