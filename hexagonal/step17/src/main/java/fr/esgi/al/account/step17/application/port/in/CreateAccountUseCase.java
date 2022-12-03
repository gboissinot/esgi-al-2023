package fr.esgi.al.account.step17.application.port.in;

import fr.esgi.al.account.step17.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
