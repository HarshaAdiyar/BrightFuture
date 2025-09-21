package com.protsaha.brightfuture.model;

import lombok.Data;

// The @Data annotation from Lombok automatically generates getters, setters,
// toString(), equals(), and hashCode() methods for all fields.
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
