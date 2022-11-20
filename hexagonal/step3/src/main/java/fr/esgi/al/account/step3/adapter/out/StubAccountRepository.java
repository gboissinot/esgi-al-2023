package fr.esgi.al.account.step3.adapter.out;

import fr.esgi.al.account.step3.application.port.out.AccountRepository;
import fr.esgi.al.account.step3.domain.Account;
import fr.esgi.al.account.step3.domain.AccountId;
import fr.esgi.al.account.step3.domain.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

public final class StubAccountRepository implements AccountRepository {

    private final Map<AccountId, Account> registry = new HashMap<>();

    @Override
    public Account findBy(AccountId accountId) {
        return registry.computeIfAbsent(accountId,
                key -> {
                    throw new AccountNotFoundException();
                });
    }

    @Override
    public void save(Account account) {
        registry.put(account.id(), account);
    }
}
