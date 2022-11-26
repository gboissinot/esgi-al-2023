package fr.esgi.al.account.step3.domain;

public final class AccountException extends RuntimeException {

    private AccountException() {
    }

    private AccountException(String message) {
        super(message);
    }

    public static AccountException create() {
        throw new AccountException();
    }

    public static AccountException notFoundAccountId(AccountId accountId) {
        return new AccountException(String.format("%s not found.", accountId.value()));
    }

}
