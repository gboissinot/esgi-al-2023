package fr.esgi.al.account.step12.application.port.in;

import fr.esgi.al.account.step12.domain.AccountId;
import fr.esgi.al.kernel.CommandHandler;

public interface CreateAccountUseCase extends CommandHandler<CreateAccountCommand, AccountId> {
}
