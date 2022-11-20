package fr.esgi.al.account.step2.domain;

public final class AccountId {

    private final String value;

    private AccountId(String value) {
        this.value = value;
    }

    public static AccountId of(String value) {
        return new AccountId(value);
    }
}
