package fr.esgi.al.account.step4.adapter.in;

import fr.esgi.al.account.step4.application.AccountApplicationException;
import fr.esgi.al.account.step4.application.services.AccountService;
import fr.esgi.al.account.step4.domain.AccountId;
import fr.esgi.al.account.step4.domain.Money;

public final class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountId create(Money initialAmount) {
        try {
            return accountService.createAccount(initialAmount);
        } catch (AccountApplicationException e) {
            System.err.println("Can't create an account.");
            throw new RuntimeException();
        }
    }

    public void transfer(AccountId source, AccountId target, Money money) {
        try {
            accountService.sendMoney(source, target, money);
        } catch (AccountApplicationException e) {
            System.err.printf("Unable to transfer money between the two accounts. Cause '%s'%n", e.getMessage());
            throw new RuntimeException();
        }
    }
}
