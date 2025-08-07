package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Student")
@Data
public class Student {
    @Id
    @JsonProperty("studentId")
    private String id;
    private String name;
    private int age;
    private String email;
    private String course;
    private String dob;
    private String contactNumber1;
    private String contactNumber2;
    private AadharInfo aadharInfo;
    private Admission admission;
    private PersonalDetails personalDetails;
    private AddressDetails address;
    private Grade grade;
    private Parents parents;
    private PreviousSchool previousSchool;





    // Getters and Setters (Omitted for brevity)
}
