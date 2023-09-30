package fr.esgi.al.tps.oop.tp22;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    public void testPlayer() {
        Position initialPosition = new Position(10, 20);
        Player player = new Player(initialPosition);
        player.moveLeft(2);
        player.moveLeft(3);
        Assertions.assertEquals(new Position(5, 20)
                , player.playerReport().currentPosition());
    }


}
