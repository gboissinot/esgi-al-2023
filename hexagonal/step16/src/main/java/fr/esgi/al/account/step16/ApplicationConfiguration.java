package fr.esgi.al.account.step16;

import fr.esgi.al.account.step16.adapter.out.AccountEntityRepository;
import fr.esgi.al.account.step16.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step16.application.services.CreateAccountService;
import fr.esgi.al.account.step16.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step16.application.services.SendMoneyService;
import fr.esgi.al.account.step16.domain.AccountConfiguration;
import fr.esgi.al.kernel.BusFactory;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
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
    public CreateAccountService createAccountService() {
        return new CreateAccountService(persistenceAdapter());
    }

    @Bean
    public SendMoneyService sendMoneyService() {
        return new SendMoneyService(
                new AccountConfiguration(500), persistenceAdapter(), persistenceAdapter());
    }

    @Bean
    public GetAccountBalanceService accountBalanceService() {
        return new GetAccountBalanceService(persistenceAdapter());
    }
}
