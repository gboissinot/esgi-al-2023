package fr.esgi.al.account.step12.application.port.in;

import fr.esgi.al.account.step12.domain.Money;
import fr.esgi.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Money> {
}
