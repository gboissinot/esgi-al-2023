package fr.esgi.al.account.step8.adapter.in;

import fr.esgi.al.account.step8.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step8.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step8.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step8.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step8.domain.AccountId;
import fr.esgi.al.account.step8.domain.Money;

public final class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, SendMoneyUseCase sendMoneyUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public AccountId create(Money initialAmount) {
        return createAccountUseCase.createAccount(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        sendMoneyUseCase.sendMoney(new SendMoneyCommand(source, target, amount));
    }
}
