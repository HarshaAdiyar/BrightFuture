package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class PreviousSchool {
    private String schoolName;
    private PreviousSchoolAddress address;

    @Data
    public static class PreviousSchoolAddress {
        private String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;
    }
}
