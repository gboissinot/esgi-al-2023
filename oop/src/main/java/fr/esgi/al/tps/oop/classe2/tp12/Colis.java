package fr.esgi.al.tps.oop.classe2.tp12;

import java.time.LocalDateTime;

//Entity
final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private ColisStatus status;
    private History history;

    private Colis(ColisNumber number, LocalDateTime createdDate, ColisStatus status, History history) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = status;
        this.history = history;
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), ColisStatus.IN_PREPARATION, History.create(ColisStatus.IN_PREPARATION));
    }

    public History history() {
        return history;
    }

    public void deliver() {
        this.status = ColisStatus.DELIVERED;
        this.history = this.history.add(ColisStatus.DELIVERED);
    }

    public void cancel() {
        if (this.status != ColisStatus.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a colis in preparation");
        }
        this.status = ColisStatus.CANCELED;
        this.history = this.history.add(ColisStatus.CANCELED);
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
