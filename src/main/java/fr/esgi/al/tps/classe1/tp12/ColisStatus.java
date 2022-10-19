package fr.esgi.al.tps.classe1.tp12;

enum ColisStatus {
    IN_PREPARATION, DELIVERED, CANCELED;

    public boolean isCancelled() {
        return this == CANCELED;
    }
}
