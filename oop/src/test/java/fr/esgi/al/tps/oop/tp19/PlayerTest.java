package fr.esgi.al.tps.oop.tp19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayerTest {

    @Test
    void the_player_starts_at_a_position_anc_can_move_left() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertTrue(
                assertContains(player.recordedEvents(), new PlayerMoved(new Position(6, 20))));

    }

    private boolean assertContains(List<Event> events, Event targetEvent) {
        return events.contains(targetEvent);
    }
}
