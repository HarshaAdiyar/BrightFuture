package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GuardianAddress {

    @JsonProperty("village")
    private String village;

    @JsonProperty("taluk")
    private String taluk;

    @JsonProperty("district")
    private String district;

    @JsonProperty("pin")
    private String pin;

    @JsonProperty("contactNo")
    private String contactNo;

    // Getters and Setters

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
