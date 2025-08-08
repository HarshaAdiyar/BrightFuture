package com.protsaha.brightfuture.model;

import lombok.Data;



@Data
public class PersonalDetails {
    private String nationality;
    private String caste;
    private String scheduledCategory;
    private Integer noOfDependents;
    private String motherTongue;
    private Disability disability;

    @Data
    public static class Disability {
        private String status;
        private String type;
    }
}
