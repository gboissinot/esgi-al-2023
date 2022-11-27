package fr.esgi.al.tps.oop.classe2.tp18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PositionTest {

    @Test
    public void testPlayer() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(4);
        Assertions.assertEquals(
                Arrays.asList(new PlayerMoved(new Position(6, 20))),
                player.recordedEvents());

    }


}
