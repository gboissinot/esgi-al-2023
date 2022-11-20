package fr.esgi.al.account.step3.adapter.in;

import fr.esgi.al.account.step3.application.services.AccountService;
import fr.esgi.al.account.step3.domain.AccountId;
import fr.esgi.al.account.step3.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        accountService.sendMoney(source, target, amount);
    }
}
