package fr.esgi.al.account.step16.application.port.in;

import fr.esgi.al.account.step16.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
