package fr.esgi.al.tps.oop.tp8;

final class ReservationRequest {

    private final int numberOfRooms;
    private final int nbumberOfAdults;
    private final int numberOfChildren;

    public ReservationRequest(int numberOfRooms, int nbumberOfAdults, int numberOfChildren) {
        if (numberOfRooms > nbumberOfAdults + numberOfChildren) {
            throw new IllegalArgumentException("Reservation impossible: Chaque chambre doit être occupée.");
        }

        this.numberOfRooms = numberOfRooms;
        this.nbumberOfAdults = nbumberOfAdults;
        this.numberOfChildren = numberOfChildren;

    }
}
