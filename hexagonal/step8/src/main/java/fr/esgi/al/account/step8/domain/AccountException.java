package fr.esgi.al.account.step8.domain;

public class AccountException extends RuntimeException {
    public AccountException() {
    }

    public AccountException(String message) {
        super(message);
    }
}
