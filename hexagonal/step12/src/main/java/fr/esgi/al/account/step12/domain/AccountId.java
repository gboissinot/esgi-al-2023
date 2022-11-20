package fr.esgi.al.account.step12.domain;

import java.util.Objects;

public final class AccountId {

    private final String value;

    private AccountId(String value) {
        this.value = value;
    }

    public static AccountId of(String value) {
        return new AccountId(value);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(value, accountId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "value='" + value + '\'' +
                '}';
    }
}
