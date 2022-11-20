package fr.esgi.al.account.step9.adapter.in;

import fr.esgi.al.account.step9.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step9.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step9.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step9.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step9.domain.AccountId;
import fr.esgi.al.account.step9.domain.Money;

public final class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, SendMoneyUseCase sendMoneyUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public void create(Money initialAmount) {
        createAccountUseCase.createAccount(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        sendMoneyUseCase.sendMoney(new SendMoneyCommand(source, target, amount));
    }
}
