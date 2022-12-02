package fr.esgi.al.account.step16;

import fr.esgi.al.account.step16.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step16.adapter.out.LogNotifications;
import fr.esgi.al.account.step16.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step16.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step16.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step16.application.services.*;
import fr.esgi.al.account.step16.domain.AccountConfiguration;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.EventDispatcher;
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
    private final EventDispatcher eventDispatcher;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, AccountPersistenceAdapter persistenceAdapter, EventDispatcher eventDispatcher) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.persistenceAdapter = persistenceAdapter;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        eventDispatcher.register(TransferAcceptedEvent.class, new NotificationsService(new LogNotifications()));

        commandBus.register(SendMoneyCommand.class, new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter, persistenceAdapter, eventDispatcher));
        commandBus.register(CreateAccountCommand.class,
                new CreateAccountService(persistenceAdapter));
        queryBus.register(AccountBalanceQuery.class,
                new GetAccountBalanceService(persistenceAdapter));

    }
}
