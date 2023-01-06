package fr.esgi.al.account.step14.adapter.in;

import fr.esgi.al.account.step14.application.port.in.AccountBalanceQuery;
import fr.esgi.al.account.step14.application.port.in.CreateAccountCommand;
import fr.esgi.al.account.step14.application.port.in.SendMoneyCommand;
import fr.esgi.al.kernel.ApplicationException;
import fr.esgi.al.kernel.CommandBus;
import fr.esgi.al.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

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
        var accountId = (String) commandBus.post(new CreateAccountCommand(createAccountRequest.amount));
        return new CreateAccountResponse(accountId);
    }

    @PostMapping(value = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void transfer(@RequestBody @Valid TransferAccountRequest transferAccountRequest) {
        commandBus.post(new SendMoneyCommand(
                transferAccountRequest.sourceAccountId,
                transferAccountRequest.targetAccountId,
                transferAccountRequest.amount
        ));
    }

    @GetMapping
    public GetBalanceResponse getBalance(@RequestParam String accountId) {
        var balance = (Double) queryBus.post(new AccountBalanceQuery(accountId));
        return new GetBalanceResponse(balance);
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<Object> handleException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Bad request", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
