package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Address {
    private AddressDetail parentsAddress;
    private AddressDetail guardianAddress;

    @Data
    public static class AddressDetail {
        private String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;

    }
}
