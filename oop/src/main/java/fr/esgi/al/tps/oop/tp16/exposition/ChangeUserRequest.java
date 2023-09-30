package fr.esgi.al.tps.oop.tp16.exposition;

//DTO
public final class ChangeUserRequest {

    public final String id;
    public final String newLastName;

    public ChangeUserRequest(String id, String newLastName) {
        this.id = id;
        this.newLastName = newLastName;
    }
}
