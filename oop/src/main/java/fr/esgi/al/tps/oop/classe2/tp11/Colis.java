package fr.esgi.al.tps.oop.classe2.tp11;

import java.time.LocalDateTime;

public final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private Status status;

    private Colis(ColisNumber number, LocalDateTime createdDate, Status status) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = status;
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), Status.IN_PREPARATION);
    }

    public void markAsDelivered() {
        this.status = Status.DELIVERED;
    }

    public void cancel() {
        if (this.status != Status.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a colis in preparation");
        }
        this.status = Status.CANCELED;
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
