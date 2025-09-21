package com.protsaha.brightfuture.brightfuture;

public class PersonalDetails {
    private String nationality;
    private String caste;
    private String scheduledCategory;
    private int noOfDependents;
    private String motherTongue;
    private Disability disability;

    public static class Disability {
        private String status;
        private String type;

        // Getters and Setters
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
    }

    // Getters and Setters
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getCaste() { return caste; }
    public void setCaste(String caste) { this.caste = caste; }

    public String getScheduledCategory() { return scheduledCategory; }
    public void setScheduledCategory(String scheduledCategory) { this.scheduledCategory = scheduledCategory; }

    public int getNoOfDependents() { return noOfDependents; }
    public void setNoOfDependents(int noOfDependents) { this.noOfDependents = noOfDependents; }

    public String getMotherTongue() { return motherTongue; }
    public void setMotherTongue(String motherTongue) { this.motherTongue = motherTongue; }

    public Disability getDisability() { return disability; }
    public void setDisability(Disability disability) { this.disability = disability; }
}
