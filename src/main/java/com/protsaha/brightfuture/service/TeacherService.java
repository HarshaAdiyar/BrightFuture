package com.protsaha.brightfuture.service;

import com.protsaha.brightfuture.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherById(String id);
    Teacher addTeacher(Teacher teacher);
    void deleteTeacher(String id);
    Optional<Teacher> updateTeacher(String id, Teacher teacher);
}
