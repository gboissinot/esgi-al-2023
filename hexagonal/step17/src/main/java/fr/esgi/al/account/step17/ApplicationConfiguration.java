package fr.esgi.al.account.step17;

import fr.esgi.al.account.step17.adapter.out.AccountEntityRepository;
import fr.esgi.al.account.step17.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step17.adapter.out.LogNotifications;
import fr.esgi.al.account.step17.application.services.*;
import fr.esgi.al.account.step17.domain.AccountConfiguration;
import fr.esgi.al.kernel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Autowired
    private AccountEntityRepository accountEntityRepository;

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter(accountEntityRepository);
    }

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }

    @Bean
    public EventDispatcher eventDispatcher() {
        return DefaultEventDispatcher.create();
    }

    @Bean
    public CreateAccountService createAccountService() {
        return new CreateAccountService(persistenceAdapter(), eventDispatcher());
    }

    @Bean
    public SendMoneyService sendMoneyService() {
        return new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter(), persistenceAdapter(), eventDispatcher());
    }

    @Bean
    public GetAccountBalanceService accountBalanceService() {
        return new GetAccountBalanceService(persistenceAdapter());
    }

    @Bean
    public LogNotifications notifications() {
        return new LogNotifications();
    }

    @Bean
    public TransferAcceptedEventHandler transferAcceptedEventHandler() {
        return new TransferAcceptedEventHandler(notifications());
    }

    @Bean
    public AccountCreatedEventHandler accountCreatedEventHandler() {
        return new AccountCreatedEventHandler(notifications());
    }
}
