package fr.esgi.al.account.step13.application.port.in;

import fr.esgi.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Double> {
}
