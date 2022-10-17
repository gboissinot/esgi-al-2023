package fr.esgi.al.tps.homework.tp1;

import fr.esgi.al.tps.homework.tp1.middleware.MessageBus;

import java.util.HashMap;

final class MessageBusFactory {

    private MessageBusFactory() {
        throw new AssertionError();
    }

    public static MessageBus withInMemory() {
        return new InMemoryMessageBus(new HashMap<>());
    }
}
