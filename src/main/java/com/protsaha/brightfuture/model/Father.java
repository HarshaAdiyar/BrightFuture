package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Father {

    @JsonProperty("name")
    private String name;

    @JsonProperty("aadharNo")
    private String aadharNo;

    @JsonProperty("occupation")
    private String occupation;

    @JsonProperty("annualIncome")
    private int annualIncome;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }
}
