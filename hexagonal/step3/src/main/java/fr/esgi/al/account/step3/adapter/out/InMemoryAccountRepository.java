package fr.esgi.al.account.step3.adapter.out;

import fr.esgi.al.account.step3.application.AccountApplicationException;
import fr.esgi.al.account.step3.application.port.out.AccountRepository;
import fr.esgi.al.account.step3.domain.Account;
import fr.esgi.al.account.step3.domain.AccountId;

import java.util.HashMap;
import java.util.Map;

public final class InMemoryAccountRepository implements AccountRepository {

    private final Map<AccountId, Account> registry = new HashMap<>();

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
