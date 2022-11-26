package fr.esgi.al.account.step13;

import fr.esgi.al.account.step13.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step13.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step13.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step13.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step13.application.services.CreateAccountService;
import fr.esgi.al.account.step13.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step13.application.services.SendMoneyService;
import fr.esgi.al.account.step13.domain.AccountConfiguration;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final AccountPersistenceAdapter persistenceAdapter;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, AccountPersistenceAdapter persistenceAdapter) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        commandBus.register(SendMoneyCommand.class, new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter, persistenceAdapter));
        commandBus.register(CreateAccountCommand.class,
                new CreateAccountService(persistenceAdapter));
        queryBus.register(AccountBalanceQuery.class,
                new GetAccountBalanceService(persistenceAdapter));

    }
}
