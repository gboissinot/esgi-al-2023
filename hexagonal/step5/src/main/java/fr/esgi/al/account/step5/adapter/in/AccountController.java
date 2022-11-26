package fr.esgi.al.account.step5.adapter.in;

import fr.esgi.al.account.step5.application.AccountApplicationException;
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

    public AccountId create(Money initialAmount) {
        try {
            return accountService.createAccount(new CreeateAccountCommand(initialAmount));
        } catch (AccountApplicationException e) {
            System.err.printf("Can't create an account.");
            throw new RuntimeException();
        }
    }

    public void transfer(AccountId source, AccountId target, Money amount) {
        try {
            accountService.sendMoney(new SendMoneyCommand(source, target, amount));
        } catch (AccountApplicationException e) {
            System.err.printf("Unable to transfer money between the two accounts. Cause '%s'%n", e.getMessage());
            throw new RuntimeException();
        }
    }
}
