package com.protsaha.brightfuture.repository;

import com.protsaha.brightfuture.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

}
