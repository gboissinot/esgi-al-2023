package fr.esgi.al.account.step13.application.port.in;

import fr.esgi.al.kernel.Command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SendMoneyCommand implements Command<SendMoneyCommand> {

    @NotNull
    public final String sourceAccountId;
    @NotNull
    public final String targetAccountId;
    @NotNull
    @Positive
    public final double amount;

    public SendMoneyCommand(String sourceAccountId, String targetAccountId, double amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }
}
