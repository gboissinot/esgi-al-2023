package fr.esgi.al.tps.oop.classe2.tp16.exposition;

//DTO Object
public final class CreateUserRequest {

    public final String lastname;
    public final String firstname;

    public CreateUserRequest(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
