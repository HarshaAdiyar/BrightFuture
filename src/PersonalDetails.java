package com.protsaha.brightfuture.model;

import lombok.Data;

@Data
public class PersonalDetails {
    private  String nationality;
    private String caste;
    private String scheduledCategory;
    private int noOfDependents;
    private  String motherTongue;
    private  disability disability;

    @Data
    public  static  class  disability{
        private  String status;
        private String type;
    }
}
