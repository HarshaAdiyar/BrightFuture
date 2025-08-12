package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class PreviousSchool {
    private String schoolName;
    private Address.AddressDetail address; // Reusing AddressDetail from Address class
}
