package fr.esgi.al.tps.oop.tp18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class Player {

    private final List<Event> recordedEvents;
    private Position position;

    public Player(Position position) {
        this.position = position;
        this.recordedEvents = new ArrayList<>();
    }

    public void moveLeft(int steps) {
        this.position = position.toTheLeft(steps);
        this.recordedEvents.add(new PlayerMoved(position));
    }

    public List<Event> recordedEvents() {
        return recordedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
