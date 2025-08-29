package com.protsaha.brightfuture.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "student")
@Data
public class Student {
    @Id
    private String studentId;
    private Admission admission;
    @Field("aadharInfo")
    private AadharInfo aadharInfo;
    private Parents parents;
    private PersonalDetails personalDetails;
    private PreviousSchool previousSchool;
    private Address address;

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", admission=" + admission +
                ", aadharInfo=" + aadharInfo +
                ", parents=" + parents +
                ", personalDetails=" + personalDetails +
                ", previousSchool=" + previousSchool +
                ", address=" + address +
                '}';
    }
    // Getters and Setters (Omitted for brevity)
}
