package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Address {
    private CommonAddress parentsAddress;
    private CommonAddress guardianAddress;
}

