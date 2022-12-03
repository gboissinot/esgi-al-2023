package fr.esgi.al.account.step18.adapter.out;

import fr.esgi.al.account.step18.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step18.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step18.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step18.domain.Account;
import fr.esgi.al.account.step18.domain.AccountException;
import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.account.step18.domain.Money;

import java.util.Optional;
import java.util.UUID;

public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort, CreateAccountPort {

    private final AccountRepository accountRepository;

    public AccountPersistenceAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void save(Account account) {
        var accountEntity = new AccountEntity(account.id().value(), account.balance().value());
        accountRepository.save(accountEntity);
    }

    @Override
    public Account load(AccountId accountId) {
        final Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accountId.value());
        if (optionalAccountEntity.isPresent()) {
            var accountEntity = optionalAccountEntity.get();
            return new Account(AccountId.of(UUID.fromString(accountEntity.getId())), Money.of(accountEntity.getBalance()));
        }
        throw AccountException.notFoundAccountId(accountId);
    }

    @Override
    public void update(Account account) {
        var accountEntity = new AccountEntity(account.id().value(), account.balance().value());
        accountRepository.save(accountEntity);
    }
}