package fr.esgi.al.account.step7.application.port.in;

import fr.esgi.al.account.step7.domain.AccountId;

public interface CreateAccountUseCase {

    AccountId createAccount(CreateAccountCommand createAccountCommand);
}
