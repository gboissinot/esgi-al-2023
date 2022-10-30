package fr.esgi.al.tps.oop.classe2.tp21;

import java.util.ArrayList;
import java.util.List;

final class Player {

    private Position readPosition;

    private final List<Event> recordedEvents;

    public Player(Position intialPosition) {
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(intialPosition));
    }

    public void moveLeft(int steps) {
        this.recordedEvents.add(new PlayerMoved(steps, 0));
    }

    public Position currentPosition() {

        for (Event recordedEvent : recordedEvents) {
            if (recordedEvent instanceof PlayerTookInitialPosition) {
                whenPlayerTookPosition((PlayerTookInitialPosition) recordedEvent);
            }
            if (recordedEvent instanceof PlayerMoved) {
                whenPlayerMoved((PlayerMoved) recordedEvent);
            }
        }

        return readPosition;
    }

    private void whenPlayerTookPosition(PlayerTookInitialPosition event) {
        readPosition = event.getPosition();
    }

    private void whenPlayerMoved(PlayerMoved playerMoved) {
        readPosition = readPosition.toTheLeft(playerMoved.getX());
    }
}
