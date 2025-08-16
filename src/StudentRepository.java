package com.protsaha.brightfuture.repository;

import com.protsaha.brightfuture.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // Optional: custom methods like findByStudentAadharNo(), etc.
}
