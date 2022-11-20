package fr.esgi.al.account.step5.adapter.in;

import fr.esgi.al.account.step5.application.port.in.CreeateAccountCommand;
import fr.esgi.al.account.step5.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step5.application.services.AccountService;
import fr.esgi.al.account.step5.domain.AccountId;
import fr.esgi.al.account.step5.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void create(Money initialAmount) {
        accountService.createAccount(new CreeateAccountCommand(initialAmount));
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        accountService.sendMoney(new SendMoneyCommand(source, target, amount));
    }
}
