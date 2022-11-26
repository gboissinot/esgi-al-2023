package fr.esgi.al.account.step13.application.port.in;

import fr.esgi.al.account.step13.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
