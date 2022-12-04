package fr.esgi.al.account.step19;

import fr.esgi.al.account.step19.application.events.AccountCreatedEventHandler;
import fr.esgi.al.account.step19.application.events.TransferAcceptedEventHandler;
import fr.esgi.al.account.step19.application.services.CreateAccountService;
import fr.esgi.al.account.step19.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step19.application.services.SendMoneyService;
import fr.esgi.al.account.step19.domain.AccountConfiguration;
import fr.esgi.al.account.step19.infrastructure.AccountEntityRepository;
import fr.esgi.al.account.step19.infrastructure.JPAAccounts;
import fr.esgi.al.account.step19.infrastructure.LogNotifications;
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
    public JPAAccounts accounts() {
        return new JPAAccounts(accountEntityRepository);
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
        return new CreateAccountService(accounts(), eventDispatcher());
    }

    @Bean
    public SendMoneyService sendMoneyService() {
        return new SendMoneyService(
                new AccountConfiguration(500), accounts(), eventDispatcher());
    }

    @Bean
    public GetAccountBalanceService accountBalanceService() {
        return new GetAccountBalanceService(accounts());
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
