package fr.esgi.al.account.step13.adapter.in;

import fr.esgi.al.account.step13.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step13.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step13.application.port.in.SendMoneyCommand;
import fr.esgi.al.account.step13.domain.AccountId;
import fr.esgi.al.account.step13.domain.Money;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@SuppressWarnings("all")
public class AccountWebController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private AccountWebController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateAccountResponse create(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        var accountId = (AccountId) commandBus.post(new CreateAccountCommand(Money.of(createAccountRequest.amount)));
        return new CreateAccountResponse(accountId.value());
    }

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@RequestBody @Valid TransferAccountRequest transferAccountRequest) {
        commandBus.post(new SendMoneyCommand(
                AccountId.of(UUID.fromString(transferAccountRequest.sourceAccountId)),
                AccountId.of(UUID.fromString(transferAccountRequest.targetAccountId)),
                Money.of(transferAccountRequest.amount)
        ));
    }

    @GetMapping
    public GetBalanceResponse getBalance(@RequestParam String accountId) {
        var balance = (Money) queryBus.post(new AccountBalanceQuery(AccountId.of(UUID.fromString(accountId))));
        return new GetBalanceResponse(balance.value());
    }
}
