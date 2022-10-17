package fr.esgi.al.tps.classe2.tp20;

import java.util.Objects;

final class PlayerMoved implements Event {
    private final int x;
    private final int y;

    public PlayerMoved(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMoved that = (PlayerMoved) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
