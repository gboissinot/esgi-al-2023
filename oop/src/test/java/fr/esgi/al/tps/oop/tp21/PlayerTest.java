package fr.esgi.al.tps.oop.tp21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testPlayer() {
        var initialPosition = new Position(10, 20);
        var player = new Player(initialPosition);
        player.moveLeft(2);
        player.moveLeft(3);
        Assertions.assertEquals(new Position(5, 20), player.currentPosition());
    }
}
