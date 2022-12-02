package fr.esgi.al.account.step13.application.services;

import fr.esgi.al.account.step13.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step13.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step13.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step13.domain.Account;
import fr.esgi.al.account.step13.domain.Money;

public class CreateAccountService implements CreateAccountUseCase {

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
