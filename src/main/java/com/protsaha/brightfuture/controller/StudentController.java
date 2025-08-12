package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Student;
import com.protsaha.brightfuture.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@Tag(name = "Student Management", description = "Endpoints for managing students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @Operation(summary = "Get All Students", description = "Retrieve a list of all students.")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Student by ID", description = "Retrieve a student by their ID.")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a New Student", description = "Add a new student to the database.")
    public Student addStudent(@RequestBody Student student) {
        System.out.println("addStudent");
        System.out.println("print Student  "+student.toString());
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student by ID", description = "Delete a student using their ID.")
    public ResponseEntity<?> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
