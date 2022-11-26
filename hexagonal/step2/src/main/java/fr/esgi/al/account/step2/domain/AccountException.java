package fr.esgi.al.account.step2.domain;

public final class AccountException extends RuntimeException {

    private AccountException() {
    }

    public static AccountException create() {
        throw new AccountException();
    }
}
