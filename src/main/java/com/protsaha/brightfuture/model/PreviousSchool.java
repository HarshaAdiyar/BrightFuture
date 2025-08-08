package com.protsaha.brightfuture.model;

import lombok.Data;



@Data
public class PreviousSchool {
    private String schoolName;
    private SchoolAddress address;

    @Data
    public static class SchoolAddress {
        private String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;
    }
}
