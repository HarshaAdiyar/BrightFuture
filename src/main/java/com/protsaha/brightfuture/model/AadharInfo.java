package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AadharInfo {

    @JsonProperty("studentName")
    private String studentName;

    @JsonProperty("studentAadharNo")
    private String studentAadharNo;

    @JsonProperty("studentRdNo")
    private String studentRdNo;

    // Getters and Setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAadharNo() {
        return studentAadharNo;
    }

    public void setStudentAadharNo(String studentAadharNo) {
        this.studentAadharNo = studentAadharNo;
    }

    public String getStudentRdNo() {
        return studentRdNo;
    }

    public void setStudentRdNo(String studentRdNo) {
        this.studentRdNo = studentRdNo;
    }
}
