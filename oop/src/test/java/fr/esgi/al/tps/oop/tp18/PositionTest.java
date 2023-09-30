package fr.esgi.al.tps.oop.tp18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void the_player_starts_at_a_position_anc_can_move_left() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertTrue(
                player.recordedEvents()
                        .contains(new PlayerMoved(new Position(6, 20))));
    }
}
