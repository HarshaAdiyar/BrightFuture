package com.protsaha.brightfuture.model;

public class TeacherAadharInfo {
    private String aadharNumber;
    private boolean verified;

    // Getter and Setter for aadharNumber
    public String getAadharNumber() {
        return aadharNumber;
    }
    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    // Getter and Setter for verified
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
