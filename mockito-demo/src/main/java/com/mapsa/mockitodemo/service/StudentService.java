package com.mapsa.mockitodemo.service;

import com.mapsa.mockitodemo.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student findStudentById(Long id);

    Student createStudent(Student student);

    void deleteById(Long id);

    List<Student> searchByName(String name);
}
