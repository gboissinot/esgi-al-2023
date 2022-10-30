package fr.esgi.al.tps.oop.homework.tp1.middleware;

public interface MessageBus {
    void send(String topic, Message message);
}
