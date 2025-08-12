package com.protsaha.brightfuture.service.impl;

import com.protsaha.brightfuture.model.Student;
import com.protsaha.brightfuture.repository.StudentRepository;
import com.protsaha.brightfuture.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        System.out.println("StudentServiceImpl :: "+student);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}