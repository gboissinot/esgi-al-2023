package fr.esgi.al.tps.homework.tp1;

import fr.esgi.al.tps.homework.tp1.middleware.MessageBus;
import fr.esgi.al.tps.homework.tp1.middleware.MessageEncoder;

final class QueueLogging implements Logging {

    public static final String TOPIC_NAME = "topic-log";

    private final MessageBus messageBus;

    private QueueLogging(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    public static QueueLogging create(MessageBus messageBus) {
        //Ensure topic creation

        //Create the object
        return new QueueLogging(messageBus);
    }

    @Override
    public void log(String logMessage) {
        messageBus.send(TOPIC_NAME, MessageEncoder.encode(logMessage));
    }
}
