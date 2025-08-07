package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Address_Details {
    private Address studentAddress;     // Optional, if you want to retain main address
    private Address parentsAddress;
    private Address guardianAddress;
}
