package fr.esgi.al.tps.oop.classe2.tp11;

import java.time.LocalDateTime;
import java.util.Objects;

//Entity
final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private ColisStatus status;

    private Colis(ColisNumber number, LocalDateTime createdDate, ColisStatus status) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = status;
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), ColisStatus.IN_PREPARATION);
    }

    public void deliver() {
        this.status = ColisStatus.DELIVERED;
    }

    public void cancel() {
        if (this.status != ColisStatus.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a colis in preparation");
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
                "number='" + number + '\'' +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
