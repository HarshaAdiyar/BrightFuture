package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class Admission {
    private String dateOfAdmission;

    @JsonProperty("class")
    private String className;

    private String gender;
    private String dob;
    private int age;
    private String placeOfBirth;
    private String residential;
    private String remark;
    private String satsNo;
    private String penNo;
    private String udiseTcStatus;
    private String tcInDate;
    private String tcReceived;
    private String schoolPlace;
}
