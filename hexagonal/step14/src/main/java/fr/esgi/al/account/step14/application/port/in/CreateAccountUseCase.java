package fr.esgi.al.account.step14.application.port.in;

import fr.esgi.al.account.step14.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
