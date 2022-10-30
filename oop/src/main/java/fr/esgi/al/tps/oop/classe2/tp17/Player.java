package fr.esgi.al.tps.oop.classe2.tp17;

import java.util.Objects;

final class Player {

    private Position position;

    public Player(Position position) {
        this.position = position;
    }

    public void moveLeft(int steps) {
        this.position = position.toTheLeft(steps);
    }

    public Position currentPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
