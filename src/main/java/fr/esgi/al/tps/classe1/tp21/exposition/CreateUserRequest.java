package fr.esgi.al.tps.classe1.tp21.exposition;

//DTO
public class CreateUserRequest {

    public final String id;
    public final String username;
    public final String city;

    public CreateUserRequest(String id, String username, String city) {
        this.id = id;
        this.username = username;
        this.city = city;
    }
}
