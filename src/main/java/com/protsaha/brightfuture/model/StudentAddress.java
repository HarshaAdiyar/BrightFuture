package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class StudentAddress {
    private Address parentsAddress;
    private Address guardianAddress;
}
