package fr.esgi.al.tps.homework.tp1;

import fr.esgi.al.tps.homework.tp1.middleware.Message;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var messageBus = MessageBusFactory.withInMemory();
        var logging = QueueLogging.create(messageBus);

        var myLogMessageTemplate = "My test log message %d";
        IntStream.range(0, 10)
                .forEach(k -> logging.log(String.format(myLogMessageTemplate, k)));

        assert messageBus instanceof InMemoryMessageBus;

        var inMemoryMessageBus = (InMemoryMessageBus) messageBus;
        var queues = inMemoryMessageBus.getQueues();
        var logMessages = queues.get(QueueLogging.TOPIC_NAME);
        for (Message message : logMessages) {
            System.out.println("Log message in the topic : " + message);
        }
    }
}
