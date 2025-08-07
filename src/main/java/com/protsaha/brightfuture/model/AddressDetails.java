package com.protsaha.brightfuture.model;

import lombok.Data;
import com.protsaha.brightfuture.model.Address;
@Data
public class AddressDetails {
    private Address studentAddress;     // Optional, if you want to retain main address
    private Address parentsAddress;
    private Address guardianAddress;
}
