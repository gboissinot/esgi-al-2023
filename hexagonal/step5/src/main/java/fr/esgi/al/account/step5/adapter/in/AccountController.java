package fr.esgi.al.account.step5.adapter.in;

import fr.esgi.al.account.step5.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step5.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step5.application.services.AccountService;
import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountId create(Money initialAmount) {
        return accountService.createAccount(new CreateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        accountService.sendMoney(new SendMoneyCommand(source, target, amount));
    }
}
