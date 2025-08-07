package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admission {
    @JsonProperty("dateOfAdmission")
    private String dateOfAdmission;

    @JsonProperty("class")
    private String studentClass; // 'class' is a reserved keyword in Java

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("age")
    private int age;

    @JsonProperty("placeOfBirth")
    private String placeOfBirth;

    @JsonProperty("residential")
    private String residential;

    @JsonProperty("remark")
    private String remark;

    @JsonProperty("satsNo")
    private String satsNo;

    @JsonProperty("penNo")
    private String penNo;

    @JsonProperty("udiseTcStatus")
    private String udiseTcStatus;

    @JsonProperty("tcInDate")
    private String tcInDate;

    @JsonProperty("tcReceived")
    private String tcReceived;

    @JsonProperty("schoolPlace")
    private String schoolPlace;

    // Getters and Setters

    public String getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getResidential() {
        return residential;
    }

    public void setResidential(String residential) {
        this.residential = residential;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSatsNo() {
        return satsNo;
    }

    public void setSatsNo(String satsNo) {
        this.satsNo = satsNo;
    }

    public String getPenNo() {
        return penNo;
    }

    public void setPenNo(String penNo) {
        this.penNo = penNo;
    }

    public String getUdiseTcStatus() {
        return udiseTcStatus;
    }

    public void setUdiseTcStatus(String udiseTcStatus) {
        this.udiseTcStatus = udiseTcStatus;
    }

    public String getTcInDate() {
        return tcInDate;
    }

    public void setTcInDate(String tcInDate) {
        this.tcInDate = tcInDate;
    }

    public String getTcReceived() {
        return tcReceived;
    }

    public void setTcReceived(String tcReceived) {
        this.tcReceived = tcReceived;
    }

    public String getSchoolPlace() {
        return schoolPlace;
    }

    public void setSchoolPlace(String schoolPlace) {
        this.schoolPlace = schoolPlace;
    }
}
