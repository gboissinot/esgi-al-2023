package fr.esgi.al.account.step18;

import com.google.gson.Gson;
import fr.esgi.al.account.step18.domain.AccountCreated;
import fr.esgi.al.account.step18.domain.AccountId;
import fr.esgi.al.account.step18.domain.Money;

import java.util.UUID;

public class Main2 {

    public static void main(String[] args) throws Exception {

        AccountCreated accountCreated = new AccountCreated(AccountId.of(UUID.randomUUID()), Money.of(50d));
        Gson gson = new Gson();
        final String toJson = gson.toJson(accountCreated);
        System.out.println(toJson);

        final Class<?> targetClass = Class.forName(AccountCreated.class.getName());
        final AccountCreated regeneratedAccountCreated = (AccountCreated) gson.fromJson(toJson, targetClass);

        System.out.println(regeneratedAccountCreated.getAccountId());
        System.out.println(regeneratedAccountCreated.getAmount());
    }
}
