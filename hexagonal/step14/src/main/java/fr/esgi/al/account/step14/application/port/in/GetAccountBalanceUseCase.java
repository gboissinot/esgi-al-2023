package fr.esgi.al.account.step14.application.port.in;

import fr.esgi.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Double> {
}
