package fr.esgi.al.account.step18;

import fr.esgi.al.account.step18.application.events.AccountCreatedApplicationEvent;
import fr.esgi.al.account.step18.application.events.TransferAcceptedApplicationEvent;
import fr.esgi.al.account.step18.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step18.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step18.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step18.application.services.*;
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
    private final CreateAccountService createAccountService;
    private final GetAccountBalanceService accountBalanceService;
    private final SendMoneyService sendMoneyService;
    private final EventDispatcher eventDispatcher;
    private final TransferAcceptedEventHandler transferAcceptedEventHandler;
    private final AccountCreatedEventHandler accountCreatedEventHandler;

    public StartupApplicationListener(CommandBus commandBus, QueryBus queryBus, CreateAccountService createAccountService, GetAccountBalanceService accountBalanceService, SendMoneyService sendMoneyService, EventDispatcher eventDispatcher, TransferAcceptedEventHandler transferAcceptedEventHandler, AccountCreatedEventHandler accountCreatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.createAccountService = createAccountService;
        this.accountBalanceService = accountBalanceService;
        this.sendMoneyService = sendMoneyService;
        this.eventDispatcher = eventDispatcher;
        this.transferAcceptedEventHandler = transferAcceptedEventHandler;
        this.accountCreatedEventHandler = accountCreatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        eventDispatcher.register(TransferAcceptedApplicationEvent.class, transferAcceptedEventHandler);
        eventDispatcher.register(AccountCreatedApplicationEvent.class, accountCreatedEventHandler);

        commandBus.register(SendMoneyCommand.class, sendMoneyService);
        commandBus.register(CreateAccountCommand.class, createAccountService);
        queryBus.register(AccountBalanceQuery.class, accountBalanceService);
    }
}
