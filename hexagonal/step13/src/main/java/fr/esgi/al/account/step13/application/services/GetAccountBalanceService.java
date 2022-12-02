package fr.esgi.al.account.step13.application.services;

import fr.esgi.al.account.step13.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step13.application.port.in.GetAccountBalanceUseCase;
import fr.esgi.al.account.step13.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step13.domain.AccountId;

import java.util.UUID;

public class GetAccountBalanceService implements GetAccountBalanceUseCase {

    private final LoadAccountPort loadAccountPort;

    public GetAccountBalanceService(LoadAccountPort loadAccountPort) {
        this.loadAccountPort = loadAccountPort;
    }

    @Override
    public Double handle(AccountBalanceQuery query) {
        var account = loadAccountPort.load(AccountId.of(UUID.fromString(query.accountId)));
        return account.balance().value();
    }
}
