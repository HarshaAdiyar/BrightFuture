package com.protsaha.brightfuture.controller;


import com.protsaha.brightfuture.model.Student;
import com.protsaha.brightfuture.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // Allow requests from frontend (adjust if needed)
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody Map<String, Object> studentMap) {
        // You can log or process the map here
        System.out.println("Received student data: " + studentMap);

        // TODO: Convert map to Student entity and save
        Student student = convertToStudent(studentMap); // implement this method
        studentRepository.save(student);

        return ResponseEntity.ok("Student registered successfully!");
    }

    private Student convertToStudent(Map<String, Object> map) {
        // Example: manual extraction or use ObjectMapper
        Student student = new Student();
        student.setName((String) map.get("studentName"));
        // set other fields similarly...
        return student;
    }
}
