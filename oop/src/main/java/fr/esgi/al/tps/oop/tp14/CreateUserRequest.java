package fr.esgi.al.tps.oop.tp14;

//DTO Object
final class CreateUserRequest {

    public final String lastname;
    public final String firstname;

    public CreateUserRequest(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
