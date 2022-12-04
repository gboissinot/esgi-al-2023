package fr.esgi.al.account.step19.application.events;

import fr.esgi.al.account.step19.application.Notifications;
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
