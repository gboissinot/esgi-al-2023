package fr.esgi.al.account.step6.adapter.in;

import fr.esgi.al.account.step6.application.AccountApplicationException;
import fr.esgi.al.account.step6.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step6.application.port.in.CreateAccountUseCase;
import fr.esgi.al.account.step6.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step6.application.port.in.SendMoneyUseCase;
import fr.esgi.al.account.step6.domain.AccountId;
import fr.esgi.al.account.step6.domain.Money;

public final class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, SendMoneyUseCase sendMoneyUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
    }

    public AccountId create(Money initialAmount) {
        try {
            return createAccountUseCase.createAccount(new CreateAccountCommand(initialAmount));
        } catch (AccountApplicationException e) {
            System.err.printf("Can't create an account.");
            throw new RuntimeException();
        }
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        try {
            sendMoneyUseCase.sendMoney(new SendMoneyCommand(source, target, amount));
        } catch (AccountApplicationException e) {
            System.err.printf("Unable to transfer money between the two accounts. Cause '%s'%n", e.getMessage());
            throw new RuntimeException();
        }
    }
}
