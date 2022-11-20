package fr.esgi.al.account.step12;

import fr.esgi.al.account.step12.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.kernel.BusFactory;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter();
    }

    @Bean
    public CommandBus commandBus() {
        return BusFactory.defaultCommandBus();
    }

    @Bean
    public QueryBus queryBus() {
        return BusFactory.defaultQueryBus();
    }
}
