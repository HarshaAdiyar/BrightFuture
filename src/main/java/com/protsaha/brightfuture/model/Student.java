package com.protsaha.brightfuture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.protsaha.brightfuture.model.PersonalDetails;  // 👈 Add this
import com.protsaha.brightfuture.model.Admission;
import com.protsaha.brightfuture.model.AadharInfo;
import com.protsaha.brightfuture.model.PreviousSchool;
import com.protsaha.brightfuture.model.Parents;


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
    private StudentAddress address;
    private Grade grade;
    private Parents parents;
    private PreviousSchool previousSchool;





    // Getters and Setters (Omitted for brevity)
}
