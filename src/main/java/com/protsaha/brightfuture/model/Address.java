// File: src/main/java/com/protsaha/brightfuture/model/Address.java

package com.protsaha.brightfuture.model;

// Use this if you are using Lombok
// import lombok.Data;

// @Data // Place the @Data annotation at the class level
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Getters and Setters for the fields are also required if not using Lombok
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}