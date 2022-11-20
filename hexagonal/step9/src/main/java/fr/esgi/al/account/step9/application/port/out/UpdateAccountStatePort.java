package fr.esgi.al.account.step9.application.port.out;

import fr.esgi.al.account.step9.domain.Account;

public interface UpdateAccountStatePort {
    void update(Account account);
}
