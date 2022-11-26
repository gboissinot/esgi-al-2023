package fr.esgi.al.account.step13.domain;

import java.util.Objects;
import java.util.UUID;

public final class AccountId {

    private final UUID value;

    private AccountId(UUID value) {
        this.value = value;
    }

    public static AccountId of(UUID value) {
        return new AccountId(value);
    }

    public String value() {
        return value.toString();
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
