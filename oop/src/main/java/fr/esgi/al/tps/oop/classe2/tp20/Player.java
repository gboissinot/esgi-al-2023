package fr.esgi.al.tps.oop.classe2.tp20;

import java.util.ArrayList;
import java.util.List;

final class Player {

    private final List<Event> recordedEvents;

    public Player(Position intialPosition) {
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(intialPosition));
    }

    public void moveLeft(int steps) {
        this.recordedEvents.add(new PlayerMoved(steps, 0));
    }

    public List<Event> recordedEvents() {
        return recordedEvents;
    }

}
