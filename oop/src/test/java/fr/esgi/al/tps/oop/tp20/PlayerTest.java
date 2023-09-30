package fr.esgi.al.tps.oop.tp20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

 class PlayerTest {

    @Test
     void testPlayer() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertTrue(
                assertContains(player.recordedEvents(),
                        new PlayerMoved(4, 0)));

    }

    private boolean assertContains(List<Event> events, Event targetEvent) {
        return events.contains(targetEvent);
    }


}
