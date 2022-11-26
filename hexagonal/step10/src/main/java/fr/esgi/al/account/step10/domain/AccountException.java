package fr.esgi.al.account.step10.domain;

public class AccountException extends RuntimeException {
    private AccountException(String message) {
        super(message);
    }

    public static AccountException notFoundAccountId(AccountId accountId) {
        return new AccountException(String.format("%s not found.", accountId.value()));
    }
}
