package fr.esgi.al.tps.oop.tp24;

import fr.esgi.al.tps.oop.tp24.middleware.MessageBus;
import fr.esgi.al.tps.oop.tp24.middleware.MessageEncoder;

final class QueueLogging implements Logging {

    public static final String TOPIC_NAME = "topic-log";

    private final MessageBus messageBus;
    private final MessageEncoder messageEncoder;

    private QueueLogging(MessageBus messageBus, MessageEncoder messageEncoder) {
        this.messageBus = messageBus;
        this.messageEncoder = messageEncoder;
    }

    public static QueueLogging create(MessageBus messageBus, MessageEncoder messageEncoder) {
        //Ensure topic creation

        //Create the object
        return new QueueLogging(messageBus, messageEncoder);
    }

    @Override
    public void log(String logMessage) {
        messageBus.send(TOPIC_NAME, messageEncoder.encode(logMessage));
    }
}
