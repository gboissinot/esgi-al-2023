package fr.esgi.al.tps.oop.tp23;

public interface Listener<E extends Event> {
    void listenTo(E event);
}
