package fr.esgi.al.tps.oop.classe2.tp19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PositionTest {

    @Test
    public void testPlayer() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertTrue(
                assertContains(player.recordedEvents(), new PlayerMoved(new Position(6, 20))));

    }

    private boolean assertContains(List<Event> events, Event targetEvent) {
        return events.contains(targetEvent);
    }


}
