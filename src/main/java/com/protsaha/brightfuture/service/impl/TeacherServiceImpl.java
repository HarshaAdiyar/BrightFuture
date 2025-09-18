package com.protsaha.brightfuture.service.impl;

import com.protsaha.brightfuture.model.Teacher;
import com.protsaha.brightfuture.repository.TeacherRepository;
import com.protsaha.brightfuture.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(String id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        System.out.println("TeacherServiceImpl :: " + teacher);
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }
}
