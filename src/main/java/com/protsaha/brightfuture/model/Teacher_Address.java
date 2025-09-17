package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Teacher_Address {

    private AddressDetail address;

    @Data
    public static class AddressDetail {
        private String street;
        private String city;
        private String state;
        private String pinCode;
    }
}
