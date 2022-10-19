package fr.esgi.al.tps.classe1.tp17.exposition;

//DTO
public class CreateUserRequest {

    public final String username;
    public final String city;

    public CreateUserRequest(String username, String city) {
        this.username = username;
        this.city = city;
    }
}
