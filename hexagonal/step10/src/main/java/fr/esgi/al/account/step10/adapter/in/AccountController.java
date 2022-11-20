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
        return createAccountUseCase.createAccount(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        sendMoneyUseCase.sendMoney(new SendMoneyCommand(source, target, amount));
    }

    public Money getBalance(AccountId accountId) {
        return getAccountBalanceUseCase.balance(new AccountBalanceQuery(accountId));
    }
}
