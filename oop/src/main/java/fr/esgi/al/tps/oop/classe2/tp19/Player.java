package fr.esgi.al.tps.oop.classe2.tp19;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {

    private final List<Event> recordedEvents;
    private Position position;

    public Player(Position intialPosition) {
        this.position = intialPosition;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(intialPosition));
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
