package fr.esgi.al.tps.oop.tp17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class PositionTest {

    @Test
     void it_can_move_to_the_left() {
        var position = new Position(10, 20);
        position = position.toTheLeft(4);
        Assertions.assertEquals(new Position(6, 20), position);
    }

    @Test
     void the_player_starts_at_a_position_anc_can_move_left() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Position(6, 20), player.currentPosition());
    }

    @Test
     void it_can_move_to_the_left3() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Player(new Position(6, 20)), player);
    }


}
