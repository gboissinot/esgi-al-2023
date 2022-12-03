package fr.esgi.al.account.step18.application.port.in;

import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
