package fr.esgi.al.account.step10.application.port.in;

import fr.esgi.al.account.step10.domain.Money;

public interface GetAccountBalanceUseCase {
    Money balance(AccountBalanceQuery balanceQuery);
}
