package fr.esgi.al.account.step10.adapter.in;

import fr.esgi.al.account.step10.application.port.in.*;
import fr.esgi.al.account.step10.domain.AccountId;
import fr.esgi.al.account.step10.domain.Money;

public final class AccountController {

    private final CreateAccountUseCase createAccountUseCase;
    private final SendMoneyUseCase sendMoneyUseCase;
    private final GetAccountBalanceUseCase getAccountBalanceUseCase;

    public AccountController(CreateAccountUseCase createAccountUseCase, SendMoneyUseCase sendMoneyUseCase, GetAccountBalanceUseCase getAccountBalanceUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.sendMoneyUseCase = sendMoneyUseCase;
        this.getAccountBalanceUseCase = getAccountBalanceUseCase;
    }

    public AccountId create(Money initialAmount) {
        try {
            return createAccountUseCase.createAccount(new CreateAccountCommand(initialAmount));
        } catch (Exception e) {
            System.err.printf("Can't create an account.");
            throw new RuntimeException();
        }
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        try {
            sendMoneyUseCase.sendMoney(new SendMoneyCommand(source, target, amount));
        } catch (Exception e) {
            System.err.printf("Unable to transfer money between the two accounts. Cause '%s'%n", e.getMessage());
            throw new RuntimeException();
        }
    }

    public Money getBalance(AccountId accountId) {
        return getAccountBalanceUseCase.balance(new AccountBalanceQuery(accountId));
    }
}
