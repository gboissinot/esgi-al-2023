package fr.esgi.al.tps.homework.tp1.middleware;

import java.util.UUID;

public final class MessageEncoder {

    private MessageEncoder() {
        throw new AssertionError();
    }

    public static Message encode(String logMessage) {
        return new SimpleMessage(UUID.randomUUID().toString(), logMessage);
    }
}
