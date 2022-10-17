package fr.esgi.al.tps.classe2.tp19;

import java.util.Objects;

public class PlayerMoved implements Event {
    private final Position position;

    public PlayerMoved(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerMoved that = (PlayerMoved) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
