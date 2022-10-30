package fr.esgi.al.tps.oop.classe1.tp12;

import java.time.LocalDateTime;
import java.util.Objects;

//Entity
final class Colis {

    private final ColisId number;
    private final LocalDateTime createdDate;
    private ColisStatus status;

    private Colis(ColisId number, ColisStatus status, LocalDateTime createdDate) {
        this.number = number;
        this.status = status;
        this.createdDate = createdDate;
    }

    public static Colis create(int number) {
        return new Colis(new ColisId("#COL" + number), ColisStatus.IN_PREPARATION, LocalDateTime.now());
    }

    public void deliver() {
        this.status = ColisStatus.DELIVERED;
    }

    public void cancel() {
        if (status.isCancelled()) {
            return;
        }

        this.status = ColisStatus.CANCELED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colis colis = (Colis) o;
        return Objects.equals(number, colis.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Colis{" +
                "number=" + number +
                ", status=" + status +
                ", createdDate=" + createdDate +
                '}';
    }
}
