package fr.esgi.al.account.step18.application.port.in;

import fr.esgi.al.account.step18.domain.Money;
import fr.esgi.al.kernel.QueryHandler;

public interface GetAccountBalanceUseCase extends QueryHandler<AccountBalanceQuery, Money> {
}
