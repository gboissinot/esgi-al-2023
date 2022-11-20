package fr.esgi.al.account.step10.application.port.in;

import fr.esgi.al.account.step10.domain.AccountId;

public interface CreateAccountUseCase {

    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
