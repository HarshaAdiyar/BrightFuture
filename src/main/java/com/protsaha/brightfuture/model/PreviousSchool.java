package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class PreviousSchool {
    private String schoolName;
    private Address address;

    @Data
    public  static  class Address{
        private  String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;
    }
}