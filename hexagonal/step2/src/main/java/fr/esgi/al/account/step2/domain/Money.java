package fr.esgi.al.account.step2.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money of(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money minus(Money money) {
        return new Money(amount.subtract(money.amount));
    }

    public Money add(Money money) {
        return new Money(amount.add(money.amount));
    }

    public double value() {
        return amount.doubleValue();
    }

    public boolean isPositive() {
        return amount.intValue() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
