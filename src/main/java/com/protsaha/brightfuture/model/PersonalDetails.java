package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonalDetails {

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("caste")
    private String caste;

    @JsonProperty("scheduledCategory")
    private String scheduledCategory;

    @JsonProperty("noOfDependents")
    private int noOfDependents;

    @JsonProperty("motherTongue")
    private String motherTongue;



    // Getters and Setters

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getScheduledCategory() {
        return scheduledCategory;
    }

    public void setScheduledCategory(String scheduledCategory) {
        this.scheduledCategory = scheduledCategory;
    }

    public int getNoOfDependents() {
        return noOfDependents;
    }

    public void setNoOfDependents(int noOfDependents) {
        this.noOfDependents = noOfDependents;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

}
