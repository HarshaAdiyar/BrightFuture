package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Teacher;
import com.protsaha.brightfuture.model.TeacherAadharInfo;
import com.protsaha.brightfuture.model.Employment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TeacherTestController {

    @GetMapping("/teacher/sample")
    public Teacher getSampleTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId("T12345");

        // Employment details
        Employment employment = new Employment();
        employment.setDateOfJoining("2020-06-15");
        employment.setDesignation("Mathematics Teacher");
        employment.setDepartment("Mathematics");
        teacher.setEmployment(employment);

        // Aadhar info
        TeacherAadharInfo aadhar = new TeacherAadharInfo();
        aadhar.setAadharNumber("1234-5678-9012");
        aadhar.setVerified(true);
        teacher.setAadharInfo(aadhar);

        // Optional: empty lists
        teacher.setQualifications(new ArrayList<>());
        teacher.setExperience(new ArrayList<>());

        return teacher;
    }
}
