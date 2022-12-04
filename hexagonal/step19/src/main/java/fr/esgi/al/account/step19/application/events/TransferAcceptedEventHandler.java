package fr.esgi.al.account.step18.application.services;

import fr.esgi.al.account.step18.application.events.TransferAcceptedApplicationEvent;
import fr.esgi.al.account.step18.application.port.out.Notifications;
import fr.esgi.al.kernel.EventHandler;

public final class TransferAcceptedEventHandler implements EventHandler<TransferAcceptedApplicationEvent> {

    private final Notifications notifications;

    public TransferAcceptedEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(TransferAcceptedApplicationEvent event) {
        notifications.notify(String.format("Notification of the transfer acceptation of %f between %s and %s.",
                event.getAmount().value(),
                event.getSourceAccountId().value(),
                event.getTargetAccountId().value()));
    }
}
