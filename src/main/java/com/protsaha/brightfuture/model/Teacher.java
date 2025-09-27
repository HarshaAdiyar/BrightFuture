package com.protsaha.brightfuture.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Teacher")
@Data
public class Teacher {
    @Id
    private String teacherId;
    private Teacher_Employment employment;
    private TeacherAadharInfo aadharInfo;
    private Teacher_Personal_Details personalDetails;
    private Teacher_Address address;
    private List<Teacher_Qualification> qualifications;
    private List<Teacher_Experience> experience;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", employment=" + employment +
                ", aadharInfo=" + aadharInfo +
                ", personalDetails=" + personalDetails +
                ", address=" + address +
                ", qualifications=" + qualifications +
                ", experience=" + experience +
                '}';
    }


}
