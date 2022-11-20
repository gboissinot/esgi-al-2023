package fr.esgi.al.account.step11.application.port.out;

import fr.esgi.al.account.step11.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
