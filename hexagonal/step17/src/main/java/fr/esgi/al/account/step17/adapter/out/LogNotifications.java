package fr.esgi.al.account.step17.adapter.out;

import fr.esgi.al.account.step17.application.port.out.Notifications;

public final class LogNotifications implements Notifications {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
