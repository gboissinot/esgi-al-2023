package fr.esgi.al.account.step10.application.services;

import fr.esgi.al.account.step10.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step10.application.port.in.GetAccountBalanceUseCase;
import fr.esgi.al.account.step10.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step10.domain.Money;

public class GetAccountBalanceService implements GetAccountBalanceUseCase {

    private final LoadAccountPort loadAccountPort;

    public GetAccountBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Money balance(AccountBalanceQuery balanceQuery) {
        var account = loadAccountPort.loadAccount(balanceQuery.accountId);
        return account.balance();
    }
}
