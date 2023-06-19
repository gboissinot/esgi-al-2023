package com.esgi.al.microservices.graphql.api;

public class UserCommand {

    public String lastname;
    public String firstname;
    public String zipCode;
    public String city;

    public UserCommand(String lastname, String firstname, String zipCode, String city) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.zipCode = zipCode;
        this.city = city;
    }
}
