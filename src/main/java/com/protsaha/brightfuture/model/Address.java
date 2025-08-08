package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class Address {
    private ParentsAddress parentsAddress;
    private GuardianAddress guardianAddress;

    @Data
    public static class ParentsAddress {
        private String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;
    }

    @Data
    public static class GuardianAddress {
        private String village;
        private String taluk;
        private String district;
        private String pin;
        private String contactNo;
    }
}
