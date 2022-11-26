package fr.esgi.al.account.step6.application.port.in;

import fr.esgi.al.account.step6.domain.AccountId;

public interface CreateAccountUseCase {
    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
