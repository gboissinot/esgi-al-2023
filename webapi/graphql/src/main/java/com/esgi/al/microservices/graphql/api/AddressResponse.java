package com.esgi.al.microservices.graphql.api;

public class AddressResponse {

    public String zipCode;
    public String city;

    public AddressResponse(String zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }
}
