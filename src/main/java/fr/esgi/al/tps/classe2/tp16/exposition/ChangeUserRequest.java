package fr.esgi.al.tps.classe2.tp16.exposition;

//DTO
public class ChangeUserRequest {

    public final String id;
    public final String newLastName;

    public ChangeUserRequest(String id, String newLastName) {
        this.id = id;
        this.newLastName = newLastName;
    }
}
