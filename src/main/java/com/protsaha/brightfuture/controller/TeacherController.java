package com.protsaha.brightfuture.controller;

import com.protsaha.brightfuture.model.Teacher;
import com.protsaha.brightfuture.repository.TeacherRepository;
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
@Tag(name = "Teacher Profile Management " , description ="Endpoints For Managaing Teacher Profile " )
@CrossOrigin(origins = "https://localhost:63342", allowedHeaders = "*", methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
})
public class TeacherController {

    @Autowired
    private TeacherService teacherService; // Teacher Service Object Injected here

    @GetMapping("/api/Teacher/")
    @Operation(summary = "Get all The Teacher Profile Info" , description = "Retrieve a list of all Teachers Profile ")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();   // Teacher Services object  takes an Object From The   Services -> Impli -> Teacher Service
    }

    //Method for teacher Profile By using only id
    @GetMapping("/{id}")
    @Operation( summary = "get the Teacher Profile By using Id"  , description ="Retrieve a Teacher Profile By Using Single Id Number" )
    public ResponseEntity<?> getTeacherById(@PathVariable String id){
        Optional<Teacher> teacher= teacherService.getTeacherById(id);
        return  teacher.map(ResponseEntity::ok).orElseGet(() ->ResponseEntity.notFound().build());
    }

    //Method For Storing Data To The Database
    @PostMapping
    @Operation(summary = "Add a New Teacher" , description = "Add a new teacher  to the database.")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        System.out.println("Add a Teacher ");
        System.out.println("Print Teacher"+teacher.toString());
        return teacherService.addTeacher(teacher);
    }

    //Delete The Specific Teacher Profile From The  Database using  teacher Id
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete teacher Id " , description = "Delete teacher Specific Profile From The Database")
    public  ResponseEntity<?> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok().build();
    }
}