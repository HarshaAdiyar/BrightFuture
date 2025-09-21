package com.protsaha.brightfuture.brightfuture;

import java.time.LocalDate;

public class Admission {
    private LocalDate dateOfAdmission;
    private String studentClass;
    private String gender;
    private LocalDate dob;
    private int age;
    private String placeOfBirth;
    private String residential;
    private String remark;
    private String satsNo;
    private String penNo;
    private String udiseTcStatus;
    private LocalDate tcInDate;
    private String tcReceived;
    private String schoolPlace;

    // Getters and Setters
    public LocalDate getDateOfAdmission() { return dateOfAdmission; }
    public void setDateOfAdmission(LocalDate dateOfAdmission) { this.dateOfAdmission = dateOfAdmission; }

    public String getStudentClass() { return studentClass; }
    public void setStudentClass(String studentClass) { this.studentClass = studentClass; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPlaceOfBirth() { return placeOfBirth; }
    public void setPlaceOfBirth(String placeOfBirth) { this.placeOfBirth = placeOfBirth; }

    public String getResidential() { return residential; }
    public void setResidential(String residential) { this.residential = residential; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getSatsNo() { return satsNo; }
    public void setSatsNo(String satsNo) { this.satsNo = satsNo; }

    public String getPenNo() { return penNo; }
    public void setPenNo(String penNo) { this.penNo = penNo; }

    public String getUdiseTcStatus() { return udiseTcStatus; }
    public void setUdiseTcStatus(String udiseTcStatus) { this.udiseTcStatus = udiseTcStatus; }

    public LocalDate getTcInDate() { return tcInDate; }
    public void setTcInDate(LocalDate tcInDate) { this.tcInDate = tcInDate; }

    public String getTcReceived() { return tcReceived; }
    public void setTcReceived(String tcReceived) { this.tcReceived = tcReceived; }

    public String getSchoolPlace() { return schoolPlace; }
    public void setSchoolPlace(String schoolPlace) { this.schoolPlace = schoolPlace; }
}
