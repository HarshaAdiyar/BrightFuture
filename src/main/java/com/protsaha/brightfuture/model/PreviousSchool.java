package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreviousSchool {

    @JsonProperty("schoolName")
    private String schoolName;

    @JsonProperty("address")
    private Address address;

    // Getters and Setters

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
