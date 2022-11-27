package fr.esgi.al.account.step15.application.services;

import fr.esgi.al.account.step15.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step15.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step15.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step15.domain.Account;
import fr.esgi.al.account.step15.domain.AccountId;
import fr.esgi.al.account.step15.domain.Money;

//@Transactional
public class CreateAccountService implements CreateAccountUseCase {

    private final CreateAccountPort createAccountPort;

    public CreateAccountService(CreateAccountPort createAccountPort) {
        this.createAccountPort = createAccountPort;
    }

    @Override
    public AccountId handle(CreateAccountCommand command) {
        var accountId = createAccountPort.nextId();
        var account = new Account(accountId, Money.of(command.initialMoney));
        createAccountPort.save(account);
        return accountId;
    }
}
