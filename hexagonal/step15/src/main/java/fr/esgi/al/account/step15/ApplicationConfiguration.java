package fr.esgi.al.account.step15;

import fr.esgi.al.account.step15.adapter.out.AccountPersistenceAdapter;
import fr.esgi.al.account.step15.application.services.CreateAccountService;
import fr.esgi.al.account.step15.application.services.GetAccountBalanceService;
import fr.esgi.al.account.step15.application.services.SendMoneyService;
import fr.esgi.al.account.step15.domain.AccountConfiguration;
import fr.esgi.al.kernel.KernelConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(KernelConfiguration.class)
public class ApplicationConfiguration {

    @Bean
    public AccountPersistenceAdapter persistenceAdapter() {
        return new AccountPersistenceAdapter();
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
