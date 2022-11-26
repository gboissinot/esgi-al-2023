package fr.esgi.al.account.step7.adapter.out;

import fr.esgi.al.account.step7.application.AccountApplicationException;
import fr.esgi.al.account.step7.application.port.out.AccountRepository;
import fr.esgi.al.account.step7.domain.Account;
import fr.esgi.al.account.step7.domain.AccountId;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class InMemoryAccountRepository implements AccountRepository {

    private final Map<AccountId, Account> registry = new HashMap<>();

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public Account findById(AccountId accountId) {
        return registry.computeIfAbsent(accountId,
                key -> {
                    throw AccountApplicationException.notFoundAccountId(accountId);
                });
    }

    @Override
    public void save(Account account) {
        registry.put(account.id(), account);
    }
}
