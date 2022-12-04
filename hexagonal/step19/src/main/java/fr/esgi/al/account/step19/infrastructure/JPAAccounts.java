package fr.esgi.al.account.step18.adapter.out;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.esgi.al.account.step18.application.port.out.CreateAccountPort;
import fr.esgi.al.account.step18.application.port.out.LoadAccountPort;
import fr.esgi.al.account.step18.application.port.out.UpdateAccountStatePort;
import fr.esgi.al.account.step18.domain.Account;
import fr.esgi.al.account.step18.domain.AccountException;
import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.kernel.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort, CreateAccountPort {

    private final AccountEntityRepository accountEntityRepository;

    public AccountPersistenceAdapter(AccountEntityRepository accountEntityRepository) {
        this.accountEntityRepository = accountEntityRepository;
    }

    @Override
    public AccountId nextId() {
        return AccountId.of(UUID.randomUUID());
    }

    @Override
    public void save(Account account) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var accountEntity = new AccountEntity(account.id().value(),
                account.getRecordedEvents().stream().map(event ->
                        new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
        accountEntityRepository.save(accountEntity);
    }

    @Override
    public Account load(AccountId accountId) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        final Optional<AccountEntity> optionalAccountEntity = accountEntityRepository.findById(accountId.value());
        if (optionalAccountEntity.isPresent()) {
            var accountEntity = optionalAccountEntity.get();

            final List<EventEntity> accountEntityRecordedEvents = accountEntity.getRecordedEvents();
            final List<Event> result = new ArrayList<>();
            for (EventEntity eventEntity : accountEntityRecordedEvents) {
                try {
                    final Event event = (Event) gson.fromJson(eventEntity.getData(), Class.forName(eventEntity.getClassname()));
                    result.add(event);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return new Account(AccountId.of(UUID.fromString(accountEntity.getId())), result);
        }
        throw AccountException.notFoundAccountId(accountId);
    }

    @Override
    public void update(Account account) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var accountEntity = new AccountEntity(account.id().value(), account.getRecordedEvents().stream().map(event ->
                new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
        accountEntityRepository.save(accountEntity);
    }
}