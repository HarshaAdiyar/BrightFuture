package com.protsaha.brightfuture.model;

import lombok.Data;

// The @Data annotation generates getters and setters for the fields below.
@Data
public class PersonalDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String dateOfBirth;
    private String nationalId;
}
