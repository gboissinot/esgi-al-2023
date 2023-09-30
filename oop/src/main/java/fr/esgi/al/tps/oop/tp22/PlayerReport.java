package fr.esgi.al.tps.oop.tp22;

// Read model object
final class PlayerReport {

    private Position position;

    public void whenPlayerTookPosition(PlayerTookInitialPosition event) {
        position = event.getPosition();
    }

    public void whenPlayerMoved(PlayerMoved playerMoved) {
        position = position.toTheLeft(playerMoved.getX());
    }

    public Position currentPosition() {
        return position;
    }
}
