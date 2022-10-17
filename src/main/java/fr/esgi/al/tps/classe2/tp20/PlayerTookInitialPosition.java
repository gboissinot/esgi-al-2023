package fr.esgi.al.tps.classe2.tp20;

import java.util.Objects;

public class PlayerTookInitialPosition implements Event {

    private final Position position;

    public PlayerTookInitialPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerTookInitialPosition that = (PlayerTookInitialPosition) o;
        return Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
