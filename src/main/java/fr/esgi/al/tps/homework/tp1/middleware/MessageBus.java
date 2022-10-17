package fr.esgi.al.tps.homework.tp1.middleware;

public interface MessageBus {
    void send(String topic, Message message);
}
