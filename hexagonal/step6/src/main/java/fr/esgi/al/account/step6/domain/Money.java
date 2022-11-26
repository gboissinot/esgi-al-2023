package fr.esgi.al.account.step6.domain;

import java.math.BigDecimal;

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
}
