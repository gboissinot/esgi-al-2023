package fr.esgi.al.tps.classe2.tp17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void testPosition() {
        var position = new Position(10, 20);
        position = position.toTheLeft(4);
        Assertions.assertEquals(new Position(6, 20), position);
    }

    @Test
    public void testPlayer1() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Position(6, 20), player.currentPosition());
    }

    @Test
    public void testPlayer2() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(new Player(new Position(6, 20)), player);
    }


}
