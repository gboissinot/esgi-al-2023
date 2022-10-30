package fr.esgi.al.tps.oop.homework.tp1.middleware;

import java.util.UUID;

public final class MessageEncoder {
    public Message encode(String logMessage) {
        return new SimpleMessage(UUID.randomUUID().toString(), logMessage);
    }
}
