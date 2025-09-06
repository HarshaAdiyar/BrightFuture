package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Student;
import com.protsaha.brightfuture.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Student Management", description = "Endpoints for managing students")
@CrossOrigin(
        origins = "http://localhost:63342", // ✅ allow frontend running in IntelliJ
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ===== Get All Students =====
    @GetMapping
    @Operation(summary = "Get All Students", description = "Retrieve a list of all students.")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // ===== Get Student by ID =====
    @GetMapping("/{id}")
    @Operation(summary = "Get Student by ID", description = "Retrieve a student by their ID.")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ===== Add a New Student =====
    @PostMapping
    @Operation(summary = "Add a New Student", description = "Add a new student to the database.")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        System.out.println("📩 Incoming Student Data: " + student);
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // ===== Delete Student by ID =====
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student by ID", description = "Delete a student using their ID.")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
