package fr.esgi.al.tps.oop.classe1.tp12;

//VO
enum ColisStatus {
    IN_PREPARATION, DELIVERED, CANCELED;

    public boolean isCancelled() {
        return this == CANCELED;
    }
}
