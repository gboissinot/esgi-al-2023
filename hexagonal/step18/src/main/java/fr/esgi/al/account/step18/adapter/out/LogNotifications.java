package fr.esgi.al.account.step18.adapter.out;

import fr.esgi.al.account.step18.application.port.out.Notifications;

public class LogNotifications implements Notifications {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
