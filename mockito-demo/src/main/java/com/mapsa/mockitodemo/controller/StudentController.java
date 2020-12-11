package com.mapsa.mockitodemo.controller;

import com.mapsa.mockitodemo.domain.Student;
import com.mapsa.mockitodemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/help")
    @ResponseStatus(HttpStatus.OK)
    public String help() {
        return "Student Controller";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/search/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> searchStudentByName(@PathVariable String name) {
        return studentService.searchByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }


}
