package com.protsaha.brightfuture.brightfuture;

public class Student {
    private String studentId;
    private Admission admission;
    private AadharInfo aadharInfo;
    private Parents parents;
    private PersonalDetails personalDetails;
    private PreviousSchool previousSchool;
    private StudentAddress address;

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public Admission getAdmission() { return admission; }
    public void setAdmission(Admission admission) { this.admission = admission; }

    public AadharInfo getAadharInfo() { return aadharInfo; }
    public void setAadharInfo(AadharInfo aadharInfo) { this.aadharInfo = aadharInfo; }

    public Parents getParents() { return parents; }
    public void setParents(Parents parents) { this.parents = parents; }

    public PersonalDetails getPersonalDetails() { return personalDetails; }
    public void setPersonalDetails(PersonalDetails personalDetails) { this.personalDetails = personalDetails; }

    public PreviousSchool getPreviousSchool() { return previousSchool; }
    public void setPreviousSchool(PreviousSchool previousSchool) { this.previousSchool = previousSchool; }

    public StudentAddress getAddress() { return address; }
    public void setAddress(StudentAddress address) { this.address = address; }
}
