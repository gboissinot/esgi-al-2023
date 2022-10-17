package fr.esgi.al.tps.classe2.tp22;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Event> recordedEvents;

    public Player(Position intialPosition) {
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new PlayerTookInitialPosition(intialPosition));
    }

    public void moveLeft(int steps) {
        this.recordedEvents.add(new PlayerMoved(steps, 0));
    }

    public PlayerReport playerReport() {
        PlayerReport playerReport = new PlayerReport();
        for (Event recordedEvent : recordedEvents) {
            if (recordedEvent instanceof PlayerTookInitialPosition) {
                playerReport.whenPlayerTookPosition((PlayerTookInitialPosition) recordedEvent);
            }
            if (recordedEvent instanceof PlayerMoved) {
                playerReport.whenPlayerMoved((PlayerMoved) recordedEvent);
            }
        }

        return playerReport;
    }
}
