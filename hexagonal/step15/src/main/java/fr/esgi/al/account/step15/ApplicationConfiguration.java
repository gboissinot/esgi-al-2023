package fr.esgi.al.account.step15;

import fr.esgi.al.account.step15.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step15.adapter.out.AccountRepository;
import fr.esgi.al.kernel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {

    @Autowired
    private AccountRepository accountRepository;

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter(accountRepository);
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
}
