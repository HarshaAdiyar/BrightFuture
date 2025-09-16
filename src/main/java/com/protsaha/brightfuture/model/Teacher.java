package com.protsaha.brightfuture.model;

import java.util.List;

public class Teacher {
    private String teacherId;
    private Employment employment;
    private TeacherAadharInfo aadharInfo;
    private PersonalDetails personalDetails;
    private Address address;
    private List<Qualification> qualifications;
    private List<Experience> experience;

    // Getters and Setters
    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Employment getEmployment() {
        return employment;
    }
    public void setEmployment(Employment employment) {
        this.employment = employment;
    }

    public TeacherAadharInfo getAadharInfo() {
        return aadharInfo;
    }
    public void setAadharInfo(TeacherAadharInfo aadharInfo) {
        this.aadharInfo = aadharInfo;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }
    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<Experience> getExperience() {
        return experience;
    }
    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }
}
