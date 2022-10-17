package fr.esgi.al.tps.classe2.tp12;


import java.time.LocalDateTime;

final class Colis {

    private final ColisNumber number;
    private final LocalDateTime createdDate;
    private Status status;
    private History history;

    private Colis(ColisNumber number, LocalDateTime createdDate, Status status, History history) {
        this.number = number;
        this.createdDate = createdDate;
        this.status = status;
        this.history = history;
    }

    public static Colis create(ColisNumber number) {
        return new Colis(number, LocalDateTime.now(), Status.IN_PREPARATION, History.create(Status.IN_PREPARATION));
    }

    public History history() {
        return history;
    }

    public void markAsDelivered() {
        this.status = Status.DELIVERED;
        this.history = this.history.addStatus(Status.DELIVERED);
    }

    public void cancel() {
        if (this.status != Status.IN_PREPARATION) {
            throw new IllegalStateException("Can't cancel a colis in preparation");
        }
        this.status = Status.CANCELED;
        this.history = this.history.addStatus(Status.CANCELED);
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
