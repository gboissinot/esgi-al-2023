package fr.esgi.al.tps.homework.tp1;

import fr.esgi.al.tps.homework.tp1.middleware.Message;
import fr.esgi.al.tps.homework.tp1.middleware.MessageBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class InMemoryMessageBus implements MessageBus {

    private final Map<String, List<Message>> queues;

    InMemoryMessageBus(Map<String, List<Message>> queues) {
        this.queues = queues;
    }

    @Override
    public void send(String topic, Message message) {
        var queue = queues.get(topic);
        if (queue == null) {
            queue = new ArrayList<>();
            queues.put(topic, queue);
        }
        queue.add(message);
    }

    public Map<String, List<Message>> getQueues() {
        return queues;
    }
}
