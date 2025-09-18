package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Teacher;
import com.protsaha.brightfuture.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
@Tag(name = "Teacher Management", description = "APIs for managing teacher profiles")
@CrossOrigin(origins = "http://localhost:63342", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    @Operation(summary = "Get all teachers", description = "Retrieve a list of all teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teacher by ID", description = "Retrieve a teacher by their ID")
    public ResponseEntity<?> getTeacherById(@PathVariable String id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new teacher", description = "Create and store a new teacher profile")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        System.out.println("addTeacher");
        System.out.println("print Teacher " + teacher);
        Teacher createdTeacher = teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(createdTeacher);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update teacher by ID", description = "Update an existing teacher’s information")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String id, @RequestBody Teacher teacher) {
        Optional<Teacher> updated = teacherService.updateTeacher(id, teacher);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete teacher by ID", description = "Delete a teacher profile by their ID")
    public ResponseEntity<?> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }
}
