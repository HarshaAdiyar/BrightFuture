package com.protsaha.brightfuture.model;

import lombok.Data;

// Address Model Class
@Data
public class Address {
    private String houseNumber;
    private String houseName;
    private String street;
    private String city;
    private String taluk;
    private String district;
    private String state;
    private String country;
    private String postalCode;
}
