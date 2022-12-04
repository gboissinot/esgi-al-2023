package fr.esgi.al.account.step19.domain;

public interface Accounts {

    AccountId nextId();

    Account findById(AccountId accountId);

    void add(Account account);
}
