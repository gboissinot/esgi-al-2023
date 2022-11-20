package fr.esgi.al.account.step10.adapter.out;

import fr.esgi.al.account.step10.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step10.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step10.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step10.domain.Account;
import fr.esgi.al.account.step10.domain.AccountId;
import fr.esgi.al.account.step10.domain.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort, CreateAccountPort {

    private final Map<AccountId, Account> registry = new HashMap<>();

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID().toString());
    }

    @Override
    public void save(Account account) {
        registry.put(account.id(), account);
    }

    @Override
    public Account loadAccount(AccountId accountId) {
        return registry.computeIfAbsent(accountId,
                key -> {
                    throw new AccountNotFoundException();
                });
    }

    @Override
    public void update(Account account) {
        registry.put(account.id(), account);
    }
}