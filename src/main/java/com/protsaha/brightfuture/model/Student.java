package com.protsaha.brightfuture.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
@Data
public class Student {
    @Id
    private String studentId;
    private String name;
    private int age;
    private String dob;
    private String aadhar;
    private ContactDetails contactDetails;
    private String houseNumber;
    private String houseName;
    private Address address;
    private Grade grade;
    private Parents parents;
    private Admission admission;
    private AadharInfo aadharInfo;
    private PersonalDetails personalDetails;
    private PreviousSchool previousSchool;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob='" + dob + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", contactDetails=" + contactDetails +
                ", houseNumber='" + houseNumber + '\'' +
                ", houseName='" + houseName + '\'' +
                ", address=" + address +
                ", grade=" + grade +
                ", parents=" + parents +
                ", admission=" + admission +
                ", AadharInfo=" + aadharInfo +
                ", personalDetails=" + personalDetails +
                ", previousSchool=" + previousSchool +
                '}';
    }
}